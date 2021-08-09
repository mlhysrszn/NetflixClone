package com.mlhysrszn.netflixclone.ui.mylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.data.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyListViewModel : ViewModel() {

    var myMovieList = MutableLiveData<List<Movie>>()

    init {
        getMyMovieList()
    }

    private fun getMyMovieList() {
        val apiService = ApiUtils.getApiService()
        apiService.getMyMovieList("1").enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    myMovieList.value = films!!
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                println(t.localizedMessage?.toString())
            }
        })
    }
}