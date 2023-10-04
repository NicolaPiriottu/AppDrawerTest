package com.example.appdrawertest.core.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun checkAppVersion(
        @Url url: String,
    ): ResponseBody
}