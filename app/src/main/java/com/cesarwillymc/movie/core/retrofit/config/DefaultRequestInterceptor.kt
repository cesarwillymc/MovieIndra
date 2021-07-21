package com.cesarwillymc.movie.core.retrofit.config


import com.cesarwillymc.movie.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


class DefaultRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url()
            .newBuilder()
            .addQueryParameter(BuildConfig.API_KEY_QUERY, BuildConfig.API_KEY_VALUE)
            .build()
        val request =
            chain.request().newBuilder().url(url).build()
        return chain.proceed(request)

    }


}
