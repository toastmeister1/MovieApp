package com.joseph.tmdb_mvvm.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.ui.frag.home.adapter.MovieListAdapter

const val IMAGE_URL_THUMB = "https://image.tmdb.org/t/p/w500"
const val IMAGE_URL_ORIGIN = "https://image.tmdb.org/t/p/original"

@BindingAdapter("setImageWithSrc")
fun setImageWithSrc(view: ImageView, src: Int) {
    Glide.with(view.context)
        .load(src)
        .into(view)
}

@BindingAdapter("setImageWithURL")
fun setImageWithUrl(view: ImageView, url: String?) {
    if(url != null) {
        Glide.with(view.context)
                .load(IMAGE_URL_THUMB + url)
                .override(320,480)
                .placeholder(R.drawable.image_placeholder)
                .into(view)
    }

}

@BindingAdapter("initHorizonRecyclerAdapter")
fun initHorizontalRecyclerAdapter(view: RecyclerView, adapter: MovieListAdapter) {
    val layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
    view.apply {
        setAdapter(adapter)
        setHasFixedSize(true)
        setLayoutManager(layoutManager)
    }
}




