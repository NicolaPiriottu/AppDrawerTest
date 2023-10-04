package com.example.appdrawertest.core.service

import com.example.appdrawertest.core.Router.apiService
import com.example.appdrawertest.core.request.CheckUpdateRequest
import com.example.appdrawertest.core.response.CheckUpdateResponse
import okhttp3.ResponseBody
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import timber.log.Timber

object Repositories {

    suspend fun getCheckAppVersion(request: CheckUpdateRequest): Result<ResponseBody> {
        return runCatching {
            apiService.checkAppVersion(
                request.url
            )
        }.onFailure { e ->
            Timber.d("Get xml error $e")
        }.onSuccess {
            val serializer: Serializer = Persister()

            try {
                val dataFetch = serializer.read(
                    CheckUpdateResponse::class.java, it.string()
                )

                Timber.tag("niko").d("response : $dataFetch")
            } catch (e: Exception) {
                // Handle XML parsing error
                Timber.tag("niko").d("response : $e")
            }
        }
    }
}