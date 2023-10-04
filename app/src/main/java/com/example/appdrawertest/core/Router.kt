package com.example.appdrawertest.core

import com.example.appdrawertest.core.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.example.appdrawertest.BuildConfig

// https://etemnogrudova.medium.com/parsing-xml-using-retrofit2-in-kotlin-8e0ff6420bd7

object Router {

    private const val BASE_URL = "https://monitorps.sardegnasalute.it/monitorps/app/"

    private val client: OkHttpClient by lazy {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpBuilder = OkHttpClient.Builder()
            .readTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
        //Show Retrofit log only Debug active build variant
        if (BuildConfig.DEBUG) {
            httpBuilder.addInterceptor(logging)
        }

        httpBuilder.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}