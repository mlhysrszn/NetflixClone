package com.mlhysrszn.netflixclone.ui.films.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.squareup.picasso.Picasso

class PopularAdapter(private val popularFilms: List<Movie>) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    class PopularViewHolder(binding: ItemMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val popularBinding: ItemMediaBinding = binding
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val movie = popularFilms[position]

        Picasso.get().load(movie.moviePic).into(holder.popularBinding.movieImg)
    }

    override fun getItemCount(): Int = popularFilms.size

}