package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.UserProfilePhotosModelItem
import com.pratik.catchywall.databinding.ItemLayoutUserProfilePhotosBinding

class UserProfilePhotosListAdapter :
    PagingDataAdapter<UserProfilePhotosModelItem, UserProfilePhotosListAdapter.ViewHolder>(
        DiffUtilCallback()
    ) {

    class ViewHolder(view: ItemLayoutUserProfilePhotosBinding) :
        RecyclerView.ViewHolder(view.root) {

        private var itemLayoutCollectionBinding: ItemLayoutUserProfilePhotosBinding = view

        fun bind(
            userProfilePhotosModelItem: UserProfilePhotosModelItem?,
        ) {
            itemLayoutCollectionBinding.userProfilePhotos = userProfilePhotosModelItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val itemLayoutUserProfilePhotosBinding =
            ItemLayoutUserProfilePhotosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ViewHolder(itemLayoutUserProfilePhotosBinding)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<UserProfilePhotosModelItem>() {
        override fun areItemsTheSame(
            oldItem: UserProfilePhotosModelItem,
            newItem: UserProfilePhotosModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: UserProfilePhotosModelItem,
            newItem: UserProfilePhotosModelItem
        ): Boolean {
            return oldItem == newItem
                    && oldItem == newItem
        }
    }

}