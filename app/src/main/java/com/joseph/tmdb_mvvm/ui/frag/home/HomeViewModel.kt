package com.joseph.tmdb_mvvm.ui.frag.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.joseph.tmdb_mvvm.data.MovieListRepository
import com.joseph.tmdb_mvvm.model.MovieListResponse
import kotlinx.coroutines.flow.Flow

class HomeViewModel @ViewModelInject constructor(
    private val movieListRepository: MovieListRepository
) : ViewModel() {

    private var popularMovieList: Flow<PagingData<MovieListResponse.Movie>>? = null
    private var topRatedMovieList: Flow<PagingData<MovieListResponse.Movie>>? = null
    private var upComingMovieList: Flow<PagingData<MovieListResponse.Movie>>? = null

    fun fetchPopularMovieList(): Flow<PagingData<MovieListResponse.Movie>> {
        val lastResult = popularMovieList
        if (lastResult != null) {
            return lastResult
        }

        val newResult: Flow<PagingData<MovieListResponse.Movie>> =
            movieListRepository.fetchPopularMovieList().cachedIn(viewModelScope)
        popularMovieList = newResult

        return newResult
    }

    fun fetchTopRatedMovieList(): Flow<PagingData<MovieListResponse.Movie>> {
        val lastResult = topRatedMovieList
        if (lastResult != null) {
            return lastResult
        }

        val newResult: Flow<PagingData<MovieListResponse.Movie>> =
                movieListRepository.fetchTopRatedMovieList().cachedIn(viewModelScope)
        topRatedMovieList = newResult

        return newResult
    }

    fun fetchUpComingMovieList(): Flow<PagingData<MovieListResponse.Movie>> {
        val lastResult = upComingMovieList
        if (lastResult != null) {
            return lastResult
        }

        val newResult: Flow<PagingData<MovieListResponse.Movie>> =
                movieListRepository.fetchUpComingMovieList().cachedIn(viewModelScope)
        upComingMovieList = newResult

        return newResult
    }


}