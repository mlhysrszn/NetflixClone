package com.mlhysrszn.netflixclone.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.ItemMediaBinding
import com.mlhysrszn.netflixclone.ui.main.MainFragmentDirections
import com.squareup.picasso.Picasso

class TrendingAdapter(private val trendingList: List<Movie>) :
    RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    class TrendingViewHolder(binding: ItemMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val trendingBinding: ItemMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val movie = trendingList[position]

        Picasso.get().load(movie.moviePic).into(holder.trendingBinding.movieImg)

        holder.trendingBinding.root.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToBottomSheetFragment(movie)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = trendingList.size
}