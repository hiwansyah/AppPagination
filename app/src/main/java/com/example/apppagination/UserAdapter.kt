package com.example.apppagination

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apppagination.databinding.ItemUserBinding
import com.example.apppagination.model.DataItem



class UserAdapter(private var context: Context) :

    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    //proses setData users
    private var users = listOf<DataItem>()
    fun setData(data: List<DataItem>) {
        users = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private var binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //proses bindData
        fun bindData(user: DataItem) {

            binding.tvFullname.text = user.firstName + " " +user.lastName
            binding.tvEmail.text = user.email
            Glide.with(binding.root).load(user.avatar).circleCrop()
                .into(binding.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(users[position])
    }

    override fun getItemCount(): Int = users.size
}