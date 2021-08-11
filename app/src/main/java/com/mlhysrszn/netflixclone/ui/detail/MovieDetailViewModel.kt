package com.mlhysrszn.netflixclone.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.data.response.MovieResponse
import com.mlhysrszn.netflixclone.data.response.UpdateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {
    var moreLikeThisList = MutableLiveData<List<Movie>>()

    init {
        getRandomMovies()
    }

    private fun getRandomMovies() {
        val apiService = ApiUtils.getApiService()
        apiService.getRandomMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val films = response.body()?.movies
                if (films != null) {
                    moreLikeThisList.value = films!!
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