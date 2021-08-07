package com.mlhysrszn.netflixclone.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.data.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    var searchedMovies = MutableLiveData<List<Movie>>()

    fun searchMovie(movie_name: String){
        val apiService = ApiUtils.getApiService()
        apiService.searchMovie(movie_name).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    searchedMovies.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }
        })
    }
}