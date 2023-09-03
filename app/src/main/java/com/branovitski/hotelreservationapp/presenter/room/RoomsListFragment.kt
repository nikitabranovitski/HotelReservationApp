package com.branovitski.hotelreservationapp.presenter.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.branovitski.hotelreservationapp.R
import com.branovitski.hotelreservationapp.databinding.FragmentRoomsListBinding

class RoomsListFragment : Fragment() {

    private lateinit var binding: FragmentRoomsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRoomsListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRoomsAdapter()
    }

    private fun setupRoomsAdapter() {
        val adapter = RoomsAdapter()
        binding.roomsList.adapter = adapter
        binding.roomsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter.submitList(
            listOf(
                Room(
                    1,
                    "Стандартный номер с видом на бассейн",
                    186600,
                    "За 7 ночей с перелетом",
                    listOf("Включен только завтрак", "Кондиционер"),
                    listOf(R.drawable.image20, R.drawable.image20)
                ),
                Room(
                    2,
                    "Стандартный номер с видом на бассейн",
                    186600,
                    "За 7 ночей с перелетом",
                    listOf("Включен только завтрак", "Кондиционер"),
                    listOf(R.drawable.image20, R.drawable.image20, R.drawable.image20)
                )
            )
        )
    }


}