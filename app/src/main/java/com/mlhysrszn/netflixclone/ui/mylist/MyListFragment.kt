package com.mlhysrszn.netflixclone.ui.mylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.databinding.FragmentMyListBinding
import com.mlhysrszn.netflixclone.ui.mylist.adapter.MyListAdapter

class MyListFragment : Fragment() {

    private lateinit var binding: FragmentMyListBinding
    val viewModel: MyListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myListToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_myListFragment_to_mainFragment)
        }

        val myListRV = binding.myListRV
        myListRV.setHasFixedSize(true)

        viewModel.myMovieList.observe(viewLifecycleOwner, {
            val adapter = MyListAdapter(it)
            myListRV.adapter = adapter
        })
    }
}