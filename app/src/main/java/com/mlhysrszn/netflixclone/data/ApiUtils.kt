package com.mlhysrszn.netflixclone.data

class ApiUtils {

    companion object {
        private const val BASE_URL = "http://api.melihsozen.com/netflixclone/"

        fun getApiService(): ApiService {
            return ApiClient.getClient(BASE_URL).create(ApiService::class.java)
        }
    }
}