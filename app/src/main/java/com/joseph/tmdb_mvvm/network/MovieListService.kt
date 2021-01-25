package com.joseph.tmdb_mvvm.network

import com.joseph.tmdb_mvvm.BuildConfig
import com.joseph.tmdb_mvvm.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieListService {

    @GET("movie/popular")
    suspend fun fetchPopularMovieList(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "ko-KR",
        @Query("api_key") api_key: String = BuildConfig.TMDB_API_KEY
    ): MovieList

    @GET("movie/top_rated")
    suspend fun fetchTopRatedMovieList(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "ko-KR",
        @Query("api_key") api_key: String = BuildConfig.TMDB_API_KEY

    ): MovieList

    @GET("movie/upcoming")
    suspend fun fetchUpComingMovieList(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "ko-KR",
        @Query("api_key") api_key: String = BuildConfig.TMDB_API_KEY
    ): MovieList

    @GET("movie/{movie_id}/recommendations")
    suspend fun fetchRecommandMovieList(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "ko-KR",
        @Query("api_key") api_key: String = BuildConfig.TMDB_API_KEY
    ): MovieList

    enum class ListType {
        POPULAR, TOPRATED, UPCOMING
    }
}
