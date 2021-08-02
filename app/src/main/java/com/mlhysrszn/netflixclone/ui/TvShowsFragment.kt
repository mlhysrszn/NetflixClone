package com.mlhysrszn.netflixclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mlhysrszn.netflixclone.R

class TvShowsFragment : Fragment() {

    companion object {
        fun newInstance() = TvShowsFragment()
    }

    private lateinit var viewModel: TvShowsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

}