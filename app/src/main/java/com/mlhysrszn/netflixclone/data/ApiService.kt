package com.mlhysrszn.netflixclone.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("hollywood_films.php")
    fun getHollywoodFilms(): Call<MovieResponse>
}