package com.cesarwillymc.movie.core.retrofit.config

import okhttp3.OkHttpClient

class HttpConfiguration(private val defaultRequestInterceptor: DefaultRequestInterceptor) {

    fun onCreate(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(defaultRequestInterceptor)
            .build()
    }
}