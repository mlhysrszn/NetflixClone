package com.mlhysrszn.netflixclone.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("movies")
    @Expose
    val movies: List<Movie>,

    @SerializedName("success")
    @Expose
    val success: Int
)
