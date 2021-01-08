package com.joseph.tmdb_mvvm.ui.frag.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.joseph.tmdb_mvvm.data.MovieListRepository
import com.joseph.tmdb_mvvm.model.MovieListResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(
    private val movieListRepository: MovieListRepository
) : ViewModel() {

    private var currentMovieList: Flow<PagingData<MovieListResponse.Movie>>? = null

    fun fetchPopularMovieList(): Flow<PagingData<MovieListResponse.Movie>> {
        val lastResult = currentMovieList
        if (lastResult != null) {
            return lastResult
        }
        val newResult: Flow<PagingData<MovieListResponse.Movie>> =
            movieListRepository.fetchPopularMovieList().cachedIn(viewModelScope)
        currentMovieList = newResult

        return newResult
    }

}