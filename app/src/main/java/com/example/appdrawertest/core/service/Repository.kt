package com.example.appdrawertest.core.service

import com.example.appdrawertest.core.response.CheckUpdateResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import timber.log.Timber

class Repository {

    //CheckUpdateResponse

    suspend fun checkUpdate(response: String/*, callback: (Result<CheckUpdateResponse>) -> Unit*/) {
        coroutineScope {
            launch(Dispatchers.IO) {
                val serializer: Serializer = Persister()

                try {
                    val dataFetch = serializer.read(
                        CheckUpdateResponse::class.java, response
                    )

                    Timber.tag("niko").d("response : $dataFetch")
                } catch (e: Exception) {
                    // Handle XML parsing error
                    Timber.tag("niko").d("response : $e")
                }
            }
        }
    }

}