package com.pratik.catchywall.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pratik.catchywall.data.model.TagX
import com.pratik.catchywall.databinding.ItemLayoutTagBinding
import com.pratik.catchywall.presentation.callbacks.ChipTagClickListener

class TagChipAdapter(val chipTagClickListener: ChipTagClickListener) :
    RecyclerView.Adapter<TagChipAdapter.ViewHolder>() {

    private lateinit var binding: ItemLayoutTagBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagChipAdapter.ViewHolder {
        binding = ItemLayoutTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: TagChipAdapter.ViewHolder, position: Int) {
        holder.setData(differ.currentList[position], chipTagClickListener)
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = differ.currentList.size

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: TagX, chipTagClickListener: ChipTagClickListener) {
            binding.tag = item
            binding.chipTagClickListener = chipTagClickListener
//            binding.apply {
//                txtTag.text = item.title
//            }
        }

    }

    private val differCallback = object : DiffUtil.ItemCallback<TagX>() {
        override fun areItemsTheSame(oldItem: TagX, newItem: TagX): Boolean {
            return oldItem.title == newItem.title
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: TagX, newItem: TagX): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

}
