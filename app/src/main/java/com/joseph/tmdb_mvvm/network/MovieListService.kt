package com.joseph.tmdb_mvvm.network

import com.joseph.tmdb_mvvm.BuildConfig
import com.joseph.tmdb_mvvm.model.MovieListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListService {

    @GET("/movie/popular")
    suspend fun fetchPopularMovieList(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "ko-KR",
        @Query("api_key") api_key: String = BuildConfig.TMDB_API_KEY
    ): Flow<MovieListResponse>
}