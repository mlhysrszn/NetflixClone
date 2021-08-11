package com.mlhysrszn.netflixclone.ui.tvshows.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.mlhysrszn.netflixclone.ui.tvshows.TvShowsFragmentDirections
import com.squareup.picasso.Picasso

class PopularAdapter(private val popularList: List<Movie>) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    class PopularViewHolder(binding: ItemMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val popularBinding: ItemMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val movie = popularList[position]

        Picasso.get().load(movie.moviePic).into(holder.popularBinding.movieImg)
        holder.popularBinding.movieImg.setOnClickListener {
            val action = TvShowsFragmentDirections.actionTvShowsFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = popularList.size

}