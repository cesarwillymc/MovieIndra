package com.cesarwillymc.movie.core.retrofit


import com.cesarwillymc.movie.BuildConfig
import com.cesarwillymc.movie.core.model.BaseListMovies
import com.cesarwillymc.movie.core.retrofit.config.HttpConfiguration
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("page")
        page: Int,
        @Query("language")
        language: String = "es"
    ): Call<BaseListMovies>

    @GET("search/movie")
    fun getSearchMovies(
        @Query("query")
        word: String,
        @Query("page")
        page: Int,
        @Query("include_adult")
        include_adult: Boolean = true,
        @Query("language")
        language: String = "es"
    ): Call<BaseListMovies>

    companion object {
        operator fun invoke(httpConfiguration: HttpConfiguration): MoviesApi {
            val okHttpClient= httpConfiguration.onCreate()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesApi::class.java)
        }
    }
}
