package com.joseph.tmdb_mvvm.data

import com.joseph.tmdb_mvvm.network.MovieService
import javax.inject.Inject

class MovieRepository @Inject constructor(
        private var service: MovieService
) {
    suspend fun getMovieDetail(movieId: Int) = service.getMovieDetail(movieId)

    suspend fun getMovieCredits(movieId: Int) = service.getMovieCredit(movieId)
}