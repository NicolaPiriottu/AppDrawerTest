package com.example.appdrawertest.core.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckUpdateRequest(
    val url: String
) : Parcelable