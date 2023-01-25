package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.SearchCollectionResultResponseModel
import com.pratik.catchywall.databinding.ItemLayoutSearchCollectionBinding
import timber.log.Timber

class SearchCollectionListAdapter :
    PagingDataAdapter<SearchCollectionResultResponseModel, SearchCollectionListAdapter.SearchCollectionListViewHolder>(
        diffCallback = DiffUtilCallback()
    ) {

    class SearchCollectionListViewHolder(itemView: ItemLayoutSearchCollectionBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val itemLayoutSearchCollectionBinding: ItemLayoutSearchCollectionBinding = itemView

        fun bindView(item: SearchCollectionResultResponseModel?) {
            itemLayoutSearchCollectionBinding.searchCollectionResultResponseModel = item
        }

    }

    override fun onBindViewHolder(holder: SearchCollectionListViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): SearchCollectionListViewHolder {

        val itemLayoutSearchCollectionBinding = ItemLayoutSearchCollectionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return SearchCollectionListViewHolder(itemLayoutSearchCollectionBinding)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<SearchCollectionResultResponseModel>() {

        override fun areItemsTheSame(
            oldItem: SearchCollectionResultResponseModel,
            newItem: SearchCollectionResultResponseModel
        ): Boolean {
            Timber.d("DIFFCALL ${oldItem == newItem}")
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: SearchCollectionResultResponseModel,
            newItem: SearchCollectionResultResponseModel
        ): Boolean {
            Timber.d("DIFFCALL1 ${oldItem == newItem && oldItem == newItem}")
            return oldItem == newItem && oldItem == newItem
        }

    }

}