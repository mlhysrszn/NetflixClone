package com.mlhysrszn.netflixclone.ui.main

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.FragmentMainBinding
import com.mlhysrszn.netflixclone.ui.main.adapter.OnlyOnNetflixAdapter
import com.mlhysrszn.netflixclone.ui.main.adapter.TrendingAdapter
import com.squareup.picasso.Picasso

class MainFragment : Fragment() {

    private lateinit var popularMovie: Movie
    private lateinit var binding: FragmentMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.popularFilm.observe(viewLifecycleOwner, {
            popularMovie = it.first()
            Picasso.get().load(popularMovie.moviePic).into(binding.popularFilmImg)
            if (popularMovie.movieStatus == 1) {
                binding.addImg.setImageResource(R.drawable.ic_done)
            } else {
                binding.addImg.setImageResource(R.drawable.ic_add)
            }
        })

        binding.popularFilmImg.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToBottomSheetFragment(popularMovie)
            it.findNavController().navigate(action)
        }

        binding.infoImg.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToBottomSheetFragment(popularMovie)
            it.findNavController().navigate(action)
        }

        binding.addImg.setOnClickListener {
            if (popularMovie.movieStatus == 0) {
                viewModel.updateStatus(popularMovie.id, 1)
                popularMovie.movieStatus = 1
                binding.addImg.setImageResource(R.drawable.ic_done)
                Snackbar.make(it,"Added to MyList", Snackbar.LENGTH_SHORT).show()
            } else {
                viewModel.updateStatus(popularMovie.id, 0)
                popularMovie.movieStatus = 0
                binding.addImg.setImageResource(R.drawable.ic_add)
                Snackbar.make(it,"Removed from MyList", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.searchImg.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }

        binding.tvShowsButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_tvShowsFragment)
        }

        binding.moviesButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_filmsFragment)
        }

        binding.myListButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_myListFragment)
        }

        val trendingRV = binding.trendingNowRV
        trendingRV.setHasFixedSize(true)

        viewModel.trendingNow.observe(viewLifecycleOwner, {
            val adapter = TrendingAdapter(it)
            trendingRV.adapter = adapter
        })

        val onlyOnNetflixRV = binding.onlyOnNetflixRV
        onlyOnNetflixRV.setHasFixedSize(true)

        viewModel.onlyOnNetflix.observe(viewLifecycleOwner, {
            val adapter = OnlyOnNetflixAdapter(it)
            onlyOnNetflixRV.adapter = adapter
        })

        val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected) {
            AlertDialog.Builder(requireContext())
                .setTitle("Internet")
                .setMessage("Please check your internet connection and try again.")
                .setPositiveButton("OK") { _, _ ->
                    activity?.finish()
                }
                .show()
        }
    }
}