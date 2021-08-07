package com.mlhysrszn.netflixclone.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.databinding.FragmentSearchBinding
import com.mlhysrszn.netflixclone.ui.search.adapter.SearchAdapter

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = binding.searchToolbar
        toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_mainFragment)
        }

        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    search(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    search(newText)
                }
                return true
            }

        })
    }

    private fun search(name: String) {
        val searchRV = binding.searchRV
        searchRV.setHasFixedSize(true)
        viewModel.searchMovie(name)
        viewModel.searchedMovies.observe(viewLifecycleOwner, {
            val adapter = SearchAdapter(it)
            searchRV.adapter = adapter
        })
    }
}