package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.UserProfileLikesModelItem
import com.pratik.catchywall.databinding.ItemLayoutUserProfileLikesBinding
import com.pratik.catchywall.presentation.callbacks.SinglePhotoWallpaperClickListener

class UserProfileLikesListAdapter(private val singlePhotoWallpaperClickListener: SinglePhotoWallpaperClickListener) :

    PagingDataAdapter<UserProfileLikesModelItem, UserProfileLikesListAdapter.ViewHolder>(
        DiffUtilCallback()
    ) {

    class ViewHolder(view: ItemLayoutUserProfileLikesBinding) : RecyclerView.ViewHolder(view.root) {

        private var itemLayoutUserProfileLikesBinding: ItemLayoutUserProfileLikesBinding = view

        fun bind(
            userProfileLikesModelItem: UserProfileLikesModelItem?,
            singlePhotoWallpaperClickListener: SinglePhotoWallpaperClickListener,
        ) {
            itemLayoutUserProfileLikesBinding.userProfileLikes = userProfileLikesModelItem
            itemLayoutUserProfileLikesBinding.singlePhotoWallpaperClickListener =
                singlePhotoWallpaperClickListener
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), singlePhotoWallpaperClickListener)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {

        val itemLayoutUserProfileLikesBinding = ItemLayoutUserProfileLikesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(itemLayoutUserProfileLikesBinding)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<UserProfileLikesModelItem>() {
        override fun areItemsTheSame(
            oldItem: UserProfileLikesModelItem, newItem: UserProfileLikesModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: UserProfileLikesModelItem, newItem: UserProfileLikesModelItem
        ): Boolean {
            return oldItem == newItem && oldItem == newItem
        }
    }

}