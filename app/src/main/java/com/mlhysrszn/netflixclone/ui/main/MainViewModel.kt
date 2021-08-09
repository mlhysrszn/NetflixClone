package com.mlhysrszn.netflixclone.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.data.response.MovieResponse
import com.mlhysrszn.netflixclone.data.response.UpdateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var trendingNow = MutableLiveData<List<Movie>>()
    var onlyOnNetflix = MutableLiveData<List<Movie>>()
    var popularFilm = MutableLiveData<List<Movie>>()

    init {
        getTrendingMovies()
        getOnlyOnNetflixMovies()
        getPopularFilm()
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

    private fun getPopularFilm() {
        val apiService = ApiUtils.getApiService()
        apiService.getPopularFilm().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    popularFilm.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }

    fun updateStatus(id: Int, status: Int) {
        val apiService = ApiUtils.getApiService()
        apiService.updateStatus(id, status).enqueue(object : Callback<UpdateResponse> {
            override fun onResponse(
                call: Call<UpdateResponse>,
                response: Response<UpdateResponse>
            ) {
                val success = response.body()?.success
                val message = response.body()?.message.toString()
                Log.e("Update Message", message)
                Log.e("Success", success.toString())
            }

            override fun onFailure(call: Call<UpdateResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }
}