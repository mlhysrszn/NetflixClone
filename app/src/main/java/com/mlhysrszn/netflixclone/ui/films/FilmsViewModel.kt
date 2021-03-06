package com.mlhysrszn.netflixclone.ui.films

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.data.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsViewModel : ViewModel() {

    var hollywoodFilms = MutableLiveData<List<Movie>>()
    var popularFilmsInTurkey = MutableLiveData<List<Movie>>()
    var turkishFilms = MutableLiveData<List<Movie>>()

    init {
        getHollyWoodFilms()
        getPopularFilmsInTurkey()
        getTurkishFilms()
    }

    private fun getHollyWoodFilms() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("hollywood").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    hollywoodFilms.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }

    private fun getPopularFilmsInTurkey() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("popular_film_in_turkey").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    popularFilmsInTurkey.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }

    private fun getTurkishFilms() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("turkish_film").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    turkishFilms.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }
}