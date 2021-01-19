package com.joseph.tmdb_mvvm.util

import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.model.MovieDetail
import com.joseph.tmdb_mvvm.ui.frag.home.adapter.MovieListAdapter

const val IMAGE_URL_THUMB = "https://image.tmdb.org/t/p/w500"
const val IMAGE_URL_ORIGIN = "https://image.tmdb.org/t/p/original"

@BindingAdapter("setImageWithSrc")
fun setImageWithSrc(view: ImageView, src: Int) {
    Glide.with(view.context)
            .load(src)
            .into(view)
}

@BindingAdapter("setThumbImageWithURL")
fun setThumbImageWithUrl(view: ImageView, url: String?) {
    if (url != null) {
        Glide.with(view.context)
                .load(IMAGE_URL_THUMB + url)
                .override(320, 480)
                .placeholder(R.drawable.image_placeholder)
                .into(view)
    }
}

@BindingAdapter("setOriginImageWithURL")
fun setOriginImageWithUrl(view: ImageView, url: String?) {
    if (url != null) {
        Glide.with(view.context)
                .load(IMAGE_URL_ORIGIN + url)
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

@BindingAdapter("setText")
fun <T : Any> setText(view: TextView, text: T?) {
    text?.let {
        view.text = it.toString()
    }
}

@BindingAdapter("bindList")
fun bindList(view: ChipGroup, list: List<MovieDetail.Genre>?) {

    list?.forEach { genre ->
        val chip = Chip(view.context).apply{
            text = genre.name
            isCheckable = false
            setTextAppearance(R.style.ChipTextAppearance)
            setChipBackgroundColorResource(R.color.watchaPink)
            elevation = 2F
            gravity = Gravity.CENTER
        }

        view.addView(chip)
    }
}

@BindingAdapter("isYouthCanWatch")
fun isYouthCanWatch (view: TextView, isAdult: Boolean) {
    if(isAdult) {
        view.text = "관람불가"
    } else {
        view.text = "관람가능"
    }
}


