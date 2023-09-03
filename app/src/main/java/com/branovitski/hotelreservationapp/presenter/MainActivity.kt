package com.branovitski.hotelreservationapp.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.branovitski.hotelreservationapp.R
import com.branovitski.hotelreservationapp.presenter.hotel.HotelFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, HotelFragment::class.java, null)
            .commit()

    }
}