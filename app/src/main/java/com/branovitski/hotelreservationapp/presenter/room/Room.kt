package com.branovitski.hotelreservationapp.presenter.room

data class Room(
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val imageUrls: List<Int>
)