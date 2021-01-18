package com.joseph.tmdb_mvvm.ui.activity.detail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joseph.tmdb_mvvm.model.MovieList

class RecommandMovieAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var movieList =  ArrayList<MovieList.Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieView
}