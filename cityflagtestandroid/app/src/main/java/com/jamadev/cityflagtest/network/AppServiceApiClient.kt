package com.jamadev.cityflagtest.network

import com.jamadev.cityflagtest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AppServiceApiClient {

    private val baseUrl = "https://itunes.apple.com"

    private fun provideClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        //builder.interceptors().add()
        builder.retryOnConnectionFailure(false)

        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return builder.build()
    }

    private fun providesRetrofit( client:OkHttpClient):Retrofit{
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }


    fun provideApiService():AppServiceApi = providesRetrofit(provideClient()).create(AppServiceApi::class.java)


}