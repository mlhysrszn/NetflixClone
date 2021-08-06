package com.mlhysrszn.netflixclone

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mlhysrszn.netflixclone.data.ApiUtils
import com.mlhysrszn.netflixclone.data.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}