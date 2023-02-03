package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.UserProfilePhotosModelItem
import com.pratik.catchywall.databinding.ItemLayoutUserProfilePhotosBinding
import com.pratik.catchywall.presentation.callbacks.SinglePhotoWallpaperClickListener
import kotlin.math.sin

class UserProfilePhotosListAdapter(private val singlePhotoWallpaperClickListener: SinglePhotoWallpaperClickListener) :
    PagingDataAdapter<UserProfilePhotosModelItem, UserProfilePhotosListAdapter.ViewHolder>(
        DiffUtilCallback()
    ) {

    class ViewHolder(view: ItemLayoutUserProfilePhotosBinding) :
        RecyclerView.ViewHolder(view.root) {

        private var itemLayoutCollectionBinding: ItemLayoutUserProfilePhotosBinding = view

        fun bind(
            userProfilePhotosModelItem: UserProfilePhotosModelItem?,
            singlePhotoWallpaperClickListener: SinglePhotoWallpaperClickListener,
        ) {
            itemLayoutCollectionBinding.userProfilePhotos = userProfilePhotosModelItem
            itemLayoutCollectionBinding.singlePhotoWallpaperClickListener =
                singlePhotoWallpaperClickListener
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), singlePhotoWallpaperClickListener)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {

        val itemLayoutUserProfilePhotosBinding = ItemLayoutUserProfilePhotosBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(itemLayoutUserProfilePhotosBinding)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<UserProfilePhotosModelItem>() {
        override fun areItemsTheSame(
            oldItem: UserProfilePhotosModelItem, newItem: UserProfilePhotosModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: UserProfilePhotosModelItem, newItem: UserProfilePhotosModelItem
        ): Boolean {
            return oldItem == newItem && oldItem == newItem
        }
    }

}