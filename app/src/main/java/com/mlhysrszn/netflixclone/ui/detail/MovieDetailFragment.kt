package com.mlhysrszn.netflixclone.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.FragmentMovieDetailBinding
import com.mlhysrszn.netflixclone.ui.detail.adapter.RandomAdapter

class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var movie: Movie
        arguments?.let {
            movie = MovieDetailFragmentArgs.fromBundle(it).movie
            binding.movieNameText.text = movie.movieName
            binding.movieYearText.text = movie.movieYear.toString()
            binding.movieMaturityText.text = movie.movieMaturity
            binding.movieLengthText.text = movie.movieLength
            binding.movieDescriptionText.text = movie.movieDesc
            binding.movieStarring.text = "Starring: ${movie.movieCast}"
            if (movie.movieDirector.isNotEmpty()) {
                binding.movieDirectorText.text = "Director: ${movie.movieDirector}"
            }
        }

        val randomRV = binding.randomRV
        randomRV.setHasFixedSize(true)
        viewModel.moreLikeThisList.observe(viewLifecycleOwner, {
            val adapter = RandomAdapter(it)
            randomRV.adapter = adapter
        })

        binding.detailToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_movieDetailFragment_to_mainFragment)
        }

        binding.addToListButton.setOnClickListener {
            viewModel.updateStatus(movie.id)
            println(movie.id)
        }
    }
}