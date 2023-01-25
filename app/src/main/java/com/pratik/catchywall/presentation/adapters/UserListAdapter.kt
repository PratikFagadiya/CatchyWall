package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.User
import com.pratik.catchywall.databinding.ItemLayoutUserBinding

class UserListAdapter : PagingDataAdapter<User, UserListAdapter.UserViewHolder>(
  diffCallback =   DiffUtilCallback()
) {

    class DiffUtilCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem && oldItem == newItem
        }

    }

    class UserViewHolder(item: ItemLayoutUserBinding) : RecyclerView.ViewHolder(item.root) {
        private val itemLayoutUserBinding: ItemLayoutUserBinding = item
        fun bindView(user: User?) {
            itemLayoutUserBinding.user = user
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemLayoutUserBinding =
            ItemLayoutUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemLayoutUserBinding)
    }

}