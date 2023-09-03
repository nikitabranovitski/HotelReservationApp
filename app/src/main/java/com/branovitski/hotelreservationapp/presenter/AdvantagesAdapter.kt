package com.branovitski.hotelreservationapp.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.branovitski.hotelreservationapp.databinding.HotelAdvantagesListItemBinding

class AdvantagesAdapter :
    ListAdapter<String, AdvantagesAdapter.HotelAdvantageViewHolder>(HotelAdvantagesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelAdvantageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = HotelAdvantagesListItemBinding.inflate(inflater, parent, false)
        return HotelAdvantageViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HotelAdvantageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HotelAdvantageViewHolder(private val binding: HotelAdvantagesListItemBinding) :
        ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.hotelAdvantageTextView.text = item
        }
    }

}

private class HotelAdvantagesDiffUtil : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
}
