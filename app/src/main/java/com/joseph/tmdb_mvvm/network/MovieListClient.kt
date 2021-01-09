package com.joseph.tmdb_mvvm.network

import javax.inject.Inject

class MovieListClient @Inject constructor(
    private val movieListService: MovieListService
) {

    suspend fun fetchPopularMovieList(numPage: Int) = movieListService.fetchPopularMovieList(page = numPage)
}