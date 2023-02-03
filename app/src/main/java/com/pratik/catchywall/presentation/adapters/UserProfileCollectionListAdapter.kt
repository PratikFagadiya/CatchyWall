package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.UserProfileCollectionsModelItem
import com.pratik.catchywall.databinding.ItemLayoutUserCollectionBinding
import com.pratik.catchywall.presentation.callbacks.CollectionWallpaperListClickListener


class UserProfileCollectionListAdapter(private val collectionWallpaperListClickListener: CollectionWallpaperListClickListener) :
    PagingDataAdapter<UserProfileCollectionsModelItem, UserProfileCollectionListAdapter.ViewHolder>(
        DiffUtilCallback()
    ) {


    class ViewHolder(
        view: ItemLayoutUserCollectionBinding
    ) : RecyclerView.ViewHolder(view.root) {

        private val itemLayoutUserCollectionBinding: ItemLayoutUserCollectionBinding = view

        fun bind(
            userProfileCollectionsModelItem: UserProfileCollectionsModelItem?,
            collectionWallpaperListClickListener: CollectionWallpaperListClickListener
        ) {
            itemLayoutUserCollectionBinding.userProfileCollectionModel =
                userProfileCollectionsModelItem
            itemLayoutUserCollectionBinding.collectionWallpaperListClickListener =
                collectionWallpaperListClickListener
        }
    }

    override fun onBindViewHolder(
        holder: ViewHolder, position: Int
    ) {
        holder.bind(getItem(position), collectionWallpaperListClickListener)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val itemLayoutUserCollectionBinding = ItemLayoutUserCollectionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemLayoutUserCollectionBinding)
    }


    class DiffUtilCallback : DiffUtil.ItemCallback<UserProfileCollectionsModelItem>() {
        override fun areItemsTheSame(
            oldItem: UserProfileCollectionsModelItem, newItem: UserProfileCollectionsModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: UserProfileCollectionsModelItem, newItem: UserProfileCollectionsModelItem
        ): Boolean {
            return oldItem == newItem && oldItem == newItem
        }
    }

}