package com.mlhysrszn.netflixclone.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.MovieResponse
import com.mlhysrszn.netflixclone.databinding.FragmentFilmsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsFragment : Fragment() {

    private lateinit var binding: FragmentFilmsBinding
    private lateinit var viewModel: FilmsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getHollywoodFilms()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.FilmsToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_filmsFragment_to_mainFragment)
        }
        getHollywoodFilms()
    }

    private fun getHollywoodFilms() {
        val movieService = ApiUtils.getApiService()

        movieService.getHollywoodFilms().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                val movies = response.body()?.movies
                Log.e("MOVIES", movies.toString())

                if (movies != null) {
                    for (m in movies) {
                        Log.e("---------------------", "---------------------")
                        Log.e("movieId ", "${m.id}")
                        Log.e("movieName ", m.movieName)
                        Log.e("movieDirector ", m.movieDirector)
                        Log.e("movieLength ", m.movieLength)
                        Log.e("movieYear ", "${m.movieYear}")
                        Log.e("movieMaturity ", m.movieMaturity)
                        Log.e("movieCast ", m.movieCast)
                        Log.e("moviePic ", m.moviePic)
                        Log.e("movieDesc ", m.movieDesc)
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })
    }

}