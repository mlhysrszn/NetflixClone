package com.mlhysrszn.netflixclone.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.data.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var trendingNow = MutableLiveData<List<Movie>>()
    var onlyOnNetflix = MutableLiveData<List<Movie>>()

    init {
        getTrendingMovies()
        getOnlyOnNetflixMovies()
    }

    private fun getTrendingMovies() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("trending").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    trendingNow.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }

    private fun getOnlyOnNetflixMovies() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("only_on_netflix").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    onlyOnNetflix.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }
}