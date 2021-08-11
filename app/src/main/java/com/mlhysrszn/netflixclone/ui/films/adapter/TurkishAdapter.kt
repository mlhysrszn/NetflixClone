package com.mlhysrszn.netflixclone.ui.films.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.mlhysrszn.netflixclone.ui.films.FilmsFragmentDirections
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

        holder.turkishBinding.root.setOnClickListener {
            val action = FilmsFragmentDirections.actionFilmsFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
        Picasso.get().load(movie.moviePic).into(holder.turkishBinding.movieImg)
    }

    override fun getItemCount(): Int = turkishFilms.size

}