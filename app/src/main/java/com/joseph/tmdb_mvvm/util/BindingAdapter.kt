package com.joseph.tmdb_mvvm.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.model.MovieListResponse
import com.joseph.tmdb_mvvm.ui.frag.home.adapter.MovieListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

const val IMAGE_URL_THUMB = "https://image.tmdb.org/t/p/w500"
const val IMAGE_URL_ORIGIN = "https://image.tmdb.org/t/p/original"

@BindingAdapter("setImageWithSrc")
fun setImageWithSrc(view: ImageView, src: Int) {
    Glide.with(view.context)
        .load(src)
        .into(view)
}

@BindingAdapter("setImageWithURL")
fun setImageWithUrl(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(IMAGE_URL_THUMB + url)
        .override(320,480)
        .placeholder(R.drawable.image_placeholder)
        .into(view)
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




