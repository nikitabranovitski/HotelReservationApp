package com.branovitski.hotelreservationapp.presenter.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.branovitski.hotelreservationapp.R
import com.branovitski.hotelreservationapp.databinding.FragmentHotelBinding
import com.branovitski.hotelreservationapp.presenter.AdvantagesAdapter
import com.branovitski.hotelreservationapp.presenter.ImagesAdapter
import com.branovitski.hotelreservationapp.presenter.room.RoomsListFragment
import com.google.android.material.tabs.TabLayoutMediator

class HotelFragment : Fragment() {

    private lateinit var binding: FragmentHotelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHotelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupHotelAdvantagesAdapter()
        setupImagePager()

        binding.btnSelectRoom.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, RoomsListFragment::class.java, null).commit()
        }
    }

    private fun setupHotelAdvantagesAdapter() {
        val adapter = AdvantagesAdapter()
        binding.hotelBenefitsList.adapter = adapter
        binding.hotelBenefitsList.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        adapter.submitList(
            listOf(
                "Бесплатный Wifi на всей территории отеля",
                "1 км до пляжа",
                "Бесплатный фитнес-клуб",
                "20 км до аэропорта"
            )
        )
    }

    private fun setupImagePager() {
        val adapter = ImagesAdapter()
        binding.imagesContainer.imagesPager.adapter = adapter

        TabLayoutMediator(
            binding.imagesContainer.dotIndicatorTabLayout, binding.imagesContainer.imagesPager
        ) { _, _ -> }.attach()

        adapter.submitList(
            listOf(
                R.drawable.image20,
                R.drawable.image20,
                R.drawable.image20,
                R.drawable.image20,
                R.drawable.image20,
            )
        )
    }
}