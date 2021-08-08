package com.mlhysrszn.netflixclone.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.ItemListMediaBinding
import com.mlhysrszn.netflixclone.ui.search.SearchFragmentDirections
import com.squareup.picasso.Picasso

class SearchAdapter(private val searchedList: List<Movie>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    class SearchViewHolder(binding: ItemListMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val searchBinding: ItemListMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            ItemListMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val movie = searchedList[position]
        holder.searchBinding.movieImgParent.animation = AnimationUtils.loadAnimation(
            holder.searchBinding.movieImgParent.context,
            R.anim.search_rv_anim
        )
        holder.searchBinding.root.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
        Picasso.get().load(movie.moviePic).into(holder.searchBinding.movieImg)
    }

    override fun getItemCount(): Int = searchedList.size
}