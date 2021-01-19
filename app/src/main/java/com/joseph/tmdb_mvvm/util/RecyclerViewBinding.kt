package com.joseph.tmdb_mvvm.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joseph.tmdb_mvvm.model.MovieCredits
import com.joseph.tmdb_mvvm.ui.activity.detail.adapter.CreditsAdapter


@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("adapterCreditList")
fun bindItemList(view: RecyclerView, list: List<MovieCredits.Cast>?) {
    list?.let {
        (view.adapter as CreditsAdapter).submitList(list)
    }
}