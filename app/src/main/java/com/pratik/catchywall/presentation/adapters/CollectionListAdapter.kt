package com.pratik.catchywall.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.R
import com.pratik.catchywall.data.model.CollectionResponseModelItem
import com.pratik.catchywall.databinding.ItemLayoutCollectionBinding

class CollectionListAdapter :

    PagingDataAdapter<CollectionResponseModelItem, CollectionListAdapter.ViewHolder>(
        DiffUtilCallback()
    ) {

    class ViewHolder(view: ItemLayoutCollectionBinding) :
        RecyclerView.ViewHolder(view.root) {

        var itemLayoutCollectionBinding: ItemLayoutCollectionBinding = view

        fun bind(collectionResponseModel: CollectionResponseModelItem?) {

            itemLayoutCollectionBinding.collectionResponseModelItem = collectionResponseModel

        }

    }

//    class ViewHolder() :
//        RecyclerView.ViewHolder(itemLayoutCollectionBinding.root) {
//
//        lateinit var itemLayoutCollectionBinding1: ItemLayoutCollectionBinding
//
////        private val txtUserName: TextView = view.findViewById(R.id.txtUserName)
//
//        fun bind(collectionResponseModel: CollectionResponseModelItem) {
////            txtUserName.text = collectionResponseModel.title
//
//            itemLayoutCollectionBinding1 = this.itemLayoutCollectionBinding
//        }
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val itemLayoutCollectionBinding =
            ItemLayoutCollectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)

//        return

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