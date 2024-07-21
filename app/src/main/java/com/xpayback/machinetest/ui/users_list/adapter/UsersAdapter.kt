package com.xpayback.machinetest.ui.users_list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.xpayback.machinetest.R
import com.xpayback.machinetest.databinding.CellUsersBinding
import com.xpayback.machinetest.models.users.User

class UsersAdapter(
    private var list: MutableList<User>
) : Adapter<UsersAdapter.UsersViewHolder>() {

     class UsersViewHolder(private val binding: CellUsersBinding):ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun onBind(item: User) =binding.apply {

            textId.text = "Id: ${item.id}"
            textUserName.text = "Name: ${item.firstName} ${item.maidenName} ${item.lastName}"
            textUserEmail.text = "Email: ${item.email}"

           Glide.with(imgUser.context)
                .load(item.image)
                .centerCrop()
                .placeholder(R.drawable.ic_place_holder)
                .error(R.drawable.ic_place_holder)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgUser)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
      return UsersViewHolder(CellUsersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: MutableList<User>){
        this.list = arrayListOf()
        this.list = list
        notifyDataSetChanged()
    }
}