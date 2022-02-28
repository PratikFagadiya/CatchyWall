package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.HomeResponseModelItem
import com.pratik.catchywall.databinding.ItemLayoutHomeBinding
import com.pratik.catchywall.presentation.callbacks.HomeWallpaperClickListener

class HomeListAdapter(private val homeWallpaperClickListener: HomeWallpaperClickListener) :
    PagingDataAdapter<HomeResponseModelItem, HomeListAdapter.HomePicsViewHolder>(DiffUtilCallback()) {

    class HomePicsViewHolder(itemView: ItemLayoutHomeBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val itemLayoutHomeBinding: ItemLayoutHomeBinding = itemView

        fun bindView(
            homeResponseModelItem: HomeResponseModelItem?,
            homeWallpaperClickListener: HomeWallpaperClickListener
        ) {
            itemLayoutHomeBinding.homeResponseModelItem = homeResponseModelItem
            itemLayoutHomeBinding.homeWallpaperClickListener = homeWallpaperClickListener
        }
    }

    override fun onBindViewHolder(holder: HomePicsViewHolder, position: Int) {
        holder.bindView(getItem(position), homeWallpaperClickListener)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePicsViewHolder {

        val itemLayoutHomeBindings =
            ItemLayoutHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomePicsViewHolder(itemLayoutHomeBindings)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<HomeResponseModelItem>() {

        override fun areItemsTheSame(
            oldItem: HomeResponseModelItem,
            newItem: HomeResponseModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: HomeResponseModelItem,
            newItem: HomeResponseModelItem
        ): Boolean {
            return oldItem == newItem && oldItem == newItem
        }

    }
}