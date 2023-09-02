package com.branovitski.hotelreservationapp.presenter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.branovitski.hotelreservationapp.R

class CustomItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val imageView: ImageView
    private val textView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.hotel_info, this, true)
        imageView = findViewById(R.id.image)
        textView = findViewById(R.id.title_text_view)
    }

    fun setImage(resId: Int) {
        imageView.setImageResource(resId)
    }

    fun setText(text: String) {
        textView.text = text
    }

}
