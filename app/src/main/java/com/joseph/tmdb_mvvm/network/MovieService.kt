package com.joseph.tmdb_mvvm.network

import com.joseph.tmdb_mvvm.BuildConfig
import com.joseph.tmdb_mvvm.model.MovieCredits
import com.joseph.tmdb_mvvm.model.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "ko-KR"
    ): MovieDetail

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredit(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "ko-KR"
    ): MovieCredits
}
