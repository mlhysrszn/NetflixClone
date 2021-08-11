package com.mlhysrszn.netflixclone.ui.tvshows.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.mlhysrszn.netflixclone.ui.tvshows.TvShowsFragmentDirections
import com.squareup.picasso.Picasso

class TurkishSeriesAdapter(private val turkishSeriesList: List<Movie>) :
    RecyclerView.Adapter<TurkishSeriesAdapter.TurkishSeriesViewHolder>() {
    class TurkishSeriesViewHolder(val binding: ItemMediaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val turkishSeriesBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurkishSeriesViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TurkishSeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TurkishSeriesViewHolder, position: Int) {
        val movie = turkishSeriesList[position]

        Picasso.get().load(movie.moviePic).into(holder.turkishSeriesBinding.movieImg)
        holder.turkishSeriesBinding.movieImg.setOnClickListener {
            val action = TvShowsFragmentDirections.actionTvShowsFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = turkishSeriesList.size
}