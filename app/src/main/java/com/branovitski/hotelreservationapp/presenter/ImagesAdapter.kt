package com.branovitski.hotelreservationapp.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.branovitski.hotelreservationapp.databinding.ImagePageBinding

class ImagesAdapter : ListAdapter<Int, ImagesAdapter.ImageViewHolder>(ImageDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ImagePageBinding.inflate(inflater, parent, false)
        return ImageViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImageViewHolder(private val binding: ImagePageBinding) : ViewHolder(binding.root) {
        fun bind(item: Int) {
            binding.image.setImageResource(item)
        }

    }
}

private class ImageDiffUtil : DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
}