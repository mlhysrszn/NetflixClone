package com.mlhysrszn.netflixclone.ui.tvshows

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.data.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowsViewModel : ViewModel() {
    var popularTVShows = MutableLiveData<List<Movie>>()
    var turkishSeries = MutableLiveData<List<Movie>>()
    var documentaries = MutableLiveData<List<Movie>>()

    init {
        getPopularTVShows()
        getTurkishSeries()
        getDocumentaries()
    }

    private fun getPopularTVShows() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("trending").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    popularTVShows.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }

    private fun getTurkishSeries() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("turkish_series").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    turkishSeries.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }

    private fun getDocumentaries() {
        val apiService = ApiUtils.getApiService()
        apiService.getMovies("documentary").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    documentaries.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }

        })
    }
}