package com.example.apkroomtamires.commons.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.apkroomtamires.R

object BindingAdapter {
    @BindingAdapter("loadImg")
    @JvmStatic
    fun ImageView.loadImg(url: String) {
        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(this)
    }
}