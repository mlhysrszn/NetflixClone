package com.mlhysrszn.netflixclone.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.databinding.FragmentMainBinding
import com.mlhysrszn.netflixclone.ui.main.adapter.OnlyOnNetflixAdapter
import com.mlhysrszn.netflixclone.ui.main.adapter.TrendingAdapter

class MainFragment : Fragment() {

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
    }
}