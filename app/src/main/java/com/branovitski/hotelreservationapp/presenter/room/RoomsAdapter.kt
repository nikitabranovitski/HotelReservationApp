package com.branovitski.hotelreservationapp.presenter.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.branovitski.hotelreservationapp.databinding.RoomListItemBinding
import com.branovitski.hotelreservationapp.presenter.AdvantagesAdapter
import com.branovitski.hotelreservationapp.presenter.ImagesAdapter
import com.google.android.material.tabs.TabLayoutMediator

class RoomsAdapter : ListAdapter<Room, RoomsAdapter.RoomViewHolder>(RoomDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RoomListItemBinding.inflate(inflater, parent, false)
        return RoomViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RoomViewHolder(private val binding: RoomListItemBinding) :
        ViewHolder(binding.root) {

        fun bind(item: Room) {

            binding.tvPrice.text = "${item.price} ₽"
            binding.tvPricePeriod.text = item.pricePer
            binding.roomName.text = item.name

            val adapter = AdvantagesAdapter()
            binding.hotelBenefitsList.adapter = adapter
            binding.hotelBenefitsList.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter.submitList(item.peculiarities)

            val pagerAdapter = ImagesAdapter()
            binding.roomContainer.imagesPager.adapter = pagerAdapter

            TabLayoutMediator(
                binding.roomContainer.dotIndicatorTabLayout,
                binding.roomContainer.imagesPager
            ) { _, _ -> }.attach()

            pagerAdapter.submitList(item.imageUrls)

        }

    }
}

private class RoomDiffUtil : DiffUtil.ItemCallback<Room>() {
    override fun areItemsTheSame(oldItem: Room, newItem: Room) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Room, newItem: Room) = oldItem == newItem

}