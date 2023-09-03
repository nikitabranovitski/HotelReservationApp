package com.branovitski.hotelreservationapp.presenter.hotel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.branovitski.hotelreservationapp.R
import com.branovitski.hotelreservationapp.databinding.ViewInfoRowBinding

class InfoRowView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ViewInfoRowBinding.inflate(LayoutInflater.from(context), this)

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.InfoRowView)
        val iconResId = a.getResourceId(R.styleable.InfoRowView_icon, 0)
        val titleResId = a.getString(R.styleable.InfoRowView_title)
        val messageResId = a.getString(R.styleable.InfoRowView_message)
        setIcon(iconResId)
        setTitle(titleResId)
        setMessage(messageResId)
        a.recycle()
    }

    private fun setIcon(iconResId: Int) {
        binding.imvIcon.setImageResource(iconResId)
    }

    private fun setTitle(title: String?) {
        binding.tvTitle.text = title
    }

    private fun setMessage(message: String?) {
        binding.tvMessage.text = message
    }
}
