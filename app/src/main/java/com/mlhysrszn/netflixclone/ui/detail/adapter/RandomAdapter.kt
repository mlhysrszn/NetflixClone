package com.mlhysrszn.netflixclone.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.data.model.Movie
import com.mlhysrszn.netflixclone.databinding.ItemListMediaBinding
import com.mlhysrszn.netflixclone.ui.detail.MovieDetailFragmentDirections
import com.squareup.picasso.Picasso

class RandomAdapter(private val randomList: List<Movie>) :
    RecyclerView.Adapter<RandomAdapter.RandomViewHolder>() {

    class RandomViewHolder(binding: ItemListMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val randomBinding: ItemListMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder {
        val binding = ItemListMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RandomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
        val movie = randomList[position]
        holder.randomBinding.movieImgParent.animation = AnimationUtils.loadAnimation(
            holder.randomBinding.movieImgParent.context,
            R.anim.search_rv_anim
        )
        holder.randomBinding.root.setOnClickListener {
            val action = MovieDetailFragmentDirections.actionMovieDetailFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
        Picasso.get().load(movie.moviePic).into(holder.randomBinding.movieImg)
    }

    override fun getItemCount(): Int = randomList.size

}