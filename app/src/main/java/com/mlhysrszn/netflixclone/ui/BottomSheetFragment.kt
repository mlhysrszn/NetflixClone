package com.mlhysrszn.netflixclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.databinding.BottomSheetBinding
import com.squareup.picasso.Picasso

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var movie: Movie
    private lateinit var binding: BottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            movie = BottomSheetFragmentArgs.fromBundle(it).movie
            Picasso.get().load(movie.moviePic).into(binding.sheetMovieImage)
            binding.sheetMovieName.text = movie.movieName
            binding.sheetMovieYear.text = movie.movieYear.toString()
            binding.sheetMovieLength.text = movie.movieLength
            binding.sheetMovieMaturity.text = movie.movieMaturity
            binding.sheetMovieDescription.text = movie.movieDesc
        }
        binding.root.setOnClickListener {
            val action =
                BottomSheetFragmentDirections.actionBottomSheetFragmentToMovieDetailFragment(movie)
            parentFragment?.view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
        }
        binding.closeButton.setOnClickListener {
            dismiss()
        }
    }
}