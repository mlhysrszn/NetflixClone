package com.mlhysrszn.netflixclone.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.squareup.picasso.Picasso

class OnlyOnNetflixAdapter(private val onlyOnNetflixList: List<Movie>) :
    RecyclerView.Adapter<OnlyOnNetflixAdapter.OnlyOnNetflixViewHolder>() {

    class OnlyOnNetflixViewHolder(binding: ItemMediaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val onlyOnNetflixBinding: ItemMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnlyOnNetflixViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnlyOnNetflixViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnlyOnNetflixViewHolder, position: Int) {
        val movie = onlyOnNetflixList[position]

        Picasso.get().load(movie.moviePic).into(holder.onlyOnNetflixBinding.movieImg)
    }

    override fun getItemCount(): Int = onlyOnNetflixList.size
}