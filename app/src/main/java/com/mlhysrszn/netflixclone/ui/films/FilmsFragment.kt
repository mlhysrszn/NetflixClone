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
}