package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.CollectionResponseModelItem
import com.pratik.catchywall.databinding.ItemLayoutCollectionBinding
import com.pratik.catchywall.presentation.callbacks.CollectionItemUserClickListener
import com.pratik.catchywall.presentation.callbacks.CollectionWallpaperListClickListener

class CollectionListAdapter(
    private var collectionItemUserClickListener: CollectionItemUserClickListener,
    private var collectionWallpaperListClickListener: CollectionWallpaperListClickListener
) :

    PagingDataAdapter<CollectionResponseModelItem, CollectionListAdapter.ViewHolder>(
        DiffUtilCallback()
    ) {

    class ViewHolder(view: ItemLayoutCollectionBinding) : RecyclerView.ViewHolder(view.root) {

        private var itemLayoutCollectionBinding: ItemLayoutCollectionBinding = view

        fun bind(
            collectionResponseModel: CollectionResponseModelItem?,
            collectionItemUserClickListener: CollectionItemUserClickListener,
            collectionWallpaperListClickListener: CollectionWallpaperListClickListener
        ) {
            itemLayoutCollectionBinding.collectionResponseModelItem = collectionResponseModel
            itemLayoutCollectionBinding.userClick = collectionItemUserClickListener
            itemLayoutCollectionBinding.collectionWallpaperListClick =
                collectionWallpaperListClickListener
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            getItem(position),
            collectionItemUserClickListener,
            collectionWallpaperListClickListener
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val itemLayoutCollectionBinding =
            ItemLayoutCollectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(itemLayoutCollectionBinding)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<CollectionResponseModelItem>() {
        override fun areItemsTheSame(
            oldItem: CollectionResponseModelItem,
            newItem: CollectionResponseModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CollectionResponseModelItem,
            newItem: CollectionResponseModelItem
        ): Boolean {
            return oldItem == newItem
                    && oldItem == newItem
        }

    }

}