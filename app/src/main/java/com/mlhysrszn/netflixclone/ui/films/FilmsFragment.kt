package com.mlhysrszn.netflixclone.ui.films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.databinding.FragmentFilmsBinding
import com.mlhysrszn.netflixclone.ui.films.adapter.HollywoodAdapter
import com.mlhysrszn.netflixclone.ui.films.adapter.PopularAdapter
import com.mlhysrszn.netflixclone.ui.films.adapter.TurkishAdapter

class FilmsFragment : Fragment() {

    private lateinit var binding: FragmentFilmsBinding
    val viewModel: FilmsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.FilmsToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_filmsFragment_to_mainFragment)
        }

        val hollywoodRV = binding.HollywoodFilmsRV
        hollywoodRV.setHasFixedSize(true)

        viewModel.hollywoodFilms.observe(viewLifecycleOwner, {
            val adapter = HollywoodAdapter(it)
            hollywoodRV.adapter = adapter
        })

        val popularRV = binding.popularFilmsInTurkeyRV
        popularRV.setHasFixedSize(true)

        viewModel.popularFilmsInTurkey.observe(viewLifecycleOwner, {
            val adapter = PopularAdapter(it)
            popularRV.adapter = adapter
        })

        val turkishRV = binding.turkishFilmsRV
        turkishRV.setHasFixedSize(true)

        viewModel.turkishFilms.observe(viewLifecycleOwner, {
            val adapter = TurkishAdapter(it)
            turkishRV.adapter = adapter
        })
    }

//    private fun getHollywoodFilms() {
//        val movieService = ApiUtils.getApiService()
//
//        movieService.getHollywoodFilms().enqueue(object : Callback<MovieResponse> {
//            override fun onResponse(
//                call: Call<MovieResponse>,
//                response: Response<MovieResponse>
//            ) {
//                val movies = response.body()?.movies
//                Log.e("MOVIES", movies.toString())
//
//                if (movies != null) {
//                    for (m in movies) {
//                        Log.e("---------------------", "---------------------")
//                        Log.e("movieId ", "${m.id}")
//                        Log.e("movieName ", m.movieName)
//                        Log.e("movieDirector ", m.movieDirector)
//                        Log.e("movieLength ", m.movieLength)
//                        Log.e("movieYear ", "${m.movieYear}")
//                        Log.e("movieMaturity ", m.movieMaturity)
//                        Log.e("movieCast ", m.movieCast)
//                        Log.e("moviePic ", m.moviePic)
//                        Log.e("movieDesc ", m.movieDesc)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//            }
//
//        })
//    }

}