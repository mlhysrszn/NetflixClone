package com.mlhysrszn.netflixclone.data

import com.mlhysrszn.netflixclone.data.response.MovieResponse
import com.mlhysrszn.netflixclone.data.response.UpdateResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("movies.php")
    @FormUrlEncoded
    fun getMovies(@Field("movie_category") movie_category: String): Call<MovieResponse>

    @POST("movie_search.php")
    @FormUrlEncoded
    fun searchMovie(@Field("movie_name") movie_name: String): Call<MovieResponse>

    @POST("movie_status.php")
    @FormUrlEncoded
    fun getMyMovieList(@Field("movie_status") movie_status: String): Call<MovieResponse>

    @GET("movie_random.php")
    fun getRandomMovies(): Call<MovieResponse>

    @POST("movie_update_status.php")
    @FormUrlEncoded
    fun updateStatus(@Field("movie_id") movie_id: Int): Call<UpdateResponse>
}