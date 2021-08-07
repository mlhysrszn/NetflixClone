package com.mlhysrszn.netflixclone.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("movie_id")
    @Expose
    val id: Int,

    @SerializedName("movie_name")
    @Expose
    val movieName: String,

    @SerializedName("movie_director")
    @Expose
    val movieDirector: String,

    @SerializedName("movie_length")
    @Expose
    val movieLength: String,

    @SerializedName("movie_year")
    @Expose
    val movieYear: Int,

    @SerializedName("movie_maturity")
    @Expose
    val movieMaturity: String,

    @SerializedName("movie_cast")
    @Expose
    val movieCast: String,

    @SerializedName("movie_picture")
    @Expose
    val moviePic: String,

    @SerializedName("movie_description")
    @Expose
    val movieDesc: String,

    @SerializedName("movie_status")
    @Expose
    val movieStatus: Int
)
