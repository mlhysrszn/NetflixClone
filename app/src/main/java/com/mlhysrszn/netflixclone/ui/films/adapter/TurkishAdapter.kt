package com.mlhysrszn.netflixclone.ui.films.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.squareup.picasso.Picasso

class TurkishAdapter(private val turkishFilms: List<Movie>) :
    RecyclerView.Adapter<TurkishAdapter.TurkishViewHolder>() {

    class TurkishViewHolder(binding: ItemMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val turkishBinding: ItemMediaBinding = binding
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TurkishViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TurkishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TurkishViewHolder, position: Int) {
        val movie = turkishFilms[position]

        Picasso.get().load(movie.moviePic).into(holder.turkishBinding.movieImg)
    }

    override fun getItemCount(): Int = turkishFilms.size

}