package com.mlhysrszn.netflixclone.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("hollywood_films.php")
    fun getHollywoodFilms(): Call<MovieResponse>

    @GET("popular_films_in_turkey.php")
    fun getPopularFilmsInTurkey(): Call<MovieResponse>

    @GET("turkish_films.php")
    fun getTurkishFilms(): Call<MovieResponse>
}