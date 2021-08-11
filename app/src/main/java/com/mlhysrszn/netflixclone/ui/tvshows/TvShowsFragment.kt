package com.mlhysrszn.netflixclone.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.databinding.FragmentTvShowsBinding
import com.mlhysrszn.netflixclone.ui.tvshows.adapter.DocumentariesAdapter
import com.mlhysrszn.netflixclone.ui.tvshows.adapter.PopularAdapter
import com.mlhysrszn.netflixclone.ui.tvshows.adapter.TurkishSeriesAdapter

class TvShowsFragment : Fragment() {

    private lateinit var binding: FragmentTvShowsBinding
    val viewModel: TvShowsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvShowsToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_tvShowsFragment_to_mainFragment)
        }

        val popularRV = binding.popularTvInTurkeyRV
        popularRV.setHasFixedSize(true)
        viewModel.popularTVShows.observe(viewLifecycleOwner, {
            val adapter = PopularAdapter(it.shuffled())
            popularRV.adapter = adapter
        })

        val turkishRV = binding.turkishSeriesRV
        turkishRV.setHasFixedSize(true)
        viewModel.turkishSeries.observe(viewLifecycleOwner, {
            val adapter = TurkishSeriesAdapter(it)
            turkishRV.adapter = adapter
        })

        val documentariesRV = binding.documentariesRV
        documentariesRV.setHasFixedSize(true)
        viewModel.documentaries.observe(viewLifecycleOwner, {
            val adapter = DocumentariesAdapter(it)
            documentariesRV.adapter = adapter
        })
    }
}