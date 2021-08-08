package com.mlhysrszn.netflixclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.databinding.FragmentTvShowsBinding

class TvShowsFragment : Fragment() {

    private lateinit var binding: FragmentTvShowsBinding
    private lateinit var viewModel: TvShowsViewModel

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
    }
}