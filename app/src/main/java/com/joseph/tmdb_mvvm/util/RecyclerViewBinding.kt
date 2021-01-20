package com.joseph.tmdb_mvvm.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joseph.tmdb_mvvm.model.Movie
import com.joseph.tmdb_mvvm.model.MovieCredits
import com.joseph.tmdb_mvvm.ui.activity.detail.adapter.CreditsAdapter
import com.joseph.tmdb_mvvm.ui.activity.detail.adapter.RecommendAdapter


@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("setLayoutManager")
fun setLayoutManager(view: RecyclerView, lm: RecyclerView.LayoutManager){
    view.layoutManager = lm
}

@BindingAdapter("adapterCreditList")
fun bindCreditList(view: RecyclerView, list: List<MovieCredits.Cast>?) {
    list?.let {
        (view.adapter as CreditsAdapter).submitList(list)
    }
}

@BindingAdapter("adapterRecommendList")
fun bindRecommendList(view: RecyclerView, list: List<Movie>?) {
    list?.let {
        (view.adapter as RecommendAdapter).submitList(list)
    }
}