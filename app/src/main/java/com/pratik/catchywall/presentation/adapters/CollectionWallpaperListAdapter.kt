package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.CollectionWallpaperListModelItem
import com.pratik.catchywall.databinding.ItemLayoutCollectionWallpaperBinding
import com.pratik.catchywall.presentation.callbacks.SinglePhotoWallpaperClickListener

class CollectionWallpaperListAdapter(private val singlePhotoWallpaperClickListener: SinglePhotoWallpaperClickListener) :
    PagingDataAdapter<CollectionWallpaperListModelItem, CollectionWallpaperListAdapter.ViewHolder>(
        diffCallback = DiffUtilCallback()
    ) {

    class ViewHolder(item: ItemLayoutCollectionWallpaperBinding) :
        RecyclerView.ViewHolder(item.root) {

        private val itemBinding: ItemLayoutCollectionWallpaperBinding = item

        fun bindView(
            collectionWallpaperListModelItem: CollectionWallpaperListModelItem?,
            singlePhotoWallpaperClickListener: SinglePhotoWallpaperClickListener
        ) {
            itemBinding.collectionWallpaperListModel = collectionWallpaperListModelItem
            itemBinding.singlePhotoWallpaperClickListener = singlePhotoWallpaperClickListener
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item: ItemLayoutCollectionWallpaperBinding =
            ItemLayoutCollectionWallpaperBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ViewHolder(item)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position), singlePhotoWallpaperClickListener)
    }


    class DiffUtilCallback : DiffUtil.ItemCallback<CollectionWallpaperListModelItem>() {
        override fun areItemsTheSame(
            oldItem: CollectionWallpaperListModelItem,
            newItem: CollectionWallpaperListModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CollectionWallpaperListModelItem,
            newItem: CollectionWallpaperListModelItem
        ): Boolean {
            return oldItem == newItem && oldItem == newItem
        }
    }

}