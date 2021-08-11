package com.mlhysrszn.netflixclone.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mlhysrszn.netflixclone.data.model.Movie

data class MovieResponse(
    @SerializedName("movies")
    @Expose
    val movies: List<Movie>,

    @SerializedName("success")
    @Expose
    val success: Int
)