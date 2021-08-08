package com.mlhysrszn.netflixclone.ui.films.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.mlhysrszn.netflixclone.ui.films.FilmsFragmentDirections
import com.squareup.picasso.Picasso

class HollywoodAdapter(private val hollywoodFilms: List<Movie>) :
    RecyclerView.Adapter<HollywoodAdapter.HollywoodViewHolder>() {

    class HollywoodViewHolder(binding: ItemMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val hollywoodBinding: ItemMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HollywoodViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HollywoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HollywoodViewHolder, position: Int) {
        val movie = hollywoodFilms[position]

        holder.hollywoodBinding.root.setOnClickListener {
            val action = FilmsFragmentDirections.actionFilmsFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
        Picasso.get().load(movie.moviePic).into(holder.hollywoodBinding.movieImg)

    }

    override fun getItemCount(): Int = hollywoodFilms.size
}