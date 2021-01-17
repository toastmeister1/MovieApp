package com.joseph.tmdb_mvvm.ui.frag.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.databinding.ItemMovieBinding
import com.joseph.tmdb_mvvm.model.MovieDetail
import com.joseph.tmdb_mvvm.model.MovieList
import com.joseph.tmdb_mvvm.ui.activity.detail.MovieDetailActivity

class MovieListAdapter :
    PagingDataAdapter<MovieList.Movie, MovieListAdapter.MovieListViewHolder>(
        MOVIE_COMPARATOR
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemMovieBinding>(
            layoutInflater,
            R.layout.item_movie,
            parent,
            false
        )
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    inner class MovieListViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun onBind(item: MovieList.Movie) {

            binding.apply {
                this.movieData = item
            }

            itemView.setOnClickListener {
                var intent = Intent(it.context, MovieDetailActivity::class.java)
                intent.putExtra("movieId", item.id)
                it.context.startActivity(intent)
            }
        }

    }

    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<MovieList.Movie>() {
            override fun areItemsTheSame(
                    oldItem: MovieList.Movie,
                    newItem: MovieList.Movie
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                    oldItem: MovieList.Movie,
                    newItem: MovieList.Movie
            ): Boolean =
                oldItem == newItem
        }
    }

}