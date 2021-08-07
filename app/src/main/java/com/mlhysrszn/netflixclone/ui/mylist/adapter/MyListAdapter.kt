package com.mlhysrszn.netflixclone.ui.mylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.mlhysrszn.netflixclone.R
import com.mlhysrszn.netflixclone.data.Movie
import com.mlhysrszn.netflixclone.databinding.ItemListMediaBinding
import com.squareup.picasso.Picasso

class MyListAdapter(private val myList: List<Movie>) :
    RecyclerView.Adapter<MyListAdapter.MyListViewHolder>() {

    class MyListViewHolder(binding: ItemListMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        val myListBinding: ItemListMediaBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding =
            ItemListMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        val movie = myList[position]

        holder.myListBinding.movieImgParent.animation = AnimationUtils.loadAnimation(
            holder.myListBinding.movieImgParent.context,
            R.anim.search_rv_anim
        )

        Picasso.get().load(movie.moviePic).into(holder.myListBinding.movieImg)
    }

    override fun getItemCount(): Int = myList.size

}