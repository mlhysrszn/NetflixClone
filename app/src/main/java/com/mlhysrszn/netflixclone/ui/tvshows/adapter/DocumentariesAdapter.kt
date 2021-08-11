package com.mlhysrszn.netflixclone.ui.tvshows.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.mlhysrszn.netflixclone.ui.tvshows.TvShowsFragmentDirections
import com.squareup.picasso.Picasso

class DocumentariesAdapter(private val documentariesList: List<Movie>) :
    RecyclerView.Adapter<DocumentariesAdapter.DocumentariesViewHolder>() {
    class DocumentariesViewHolder(binding: ItemMediaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val documentariesBinding: ItemMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentariesViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DocumentariesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentariesViewHolder, position: Int) {
        val movie = documentariesList[position]

        Picasso.get().load(movie.moviePic).into(holder.documentariesBinding.movieImg)
        holder.documentariesBinding.movieImg.setOnClickListener {
            val action = TvShowsFragmentDirections.actionTvShowsFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = documentariesList.size
}