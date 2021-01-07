package com.joseph.tmdb_mvvm.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.joseph.tmdb_mvvm.R

@BindingAdapter("imageSrc")
fun setImage(view: ImageView, src: Int) {
    Glide.with(view.context)
            .load(src)
            .placeholder(R.drawable.image_placeholder)
            .into(view)
}