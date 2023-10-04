package com.example.appdrawertest

import android.app.Application
import android.webkit.WebView
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber
import com.example.appdrawertest.BuildConfig
class App: Application() {


    override fun onCreate() {
        instance = this
        super.onCreate()

        //SharedPref.initSharedPrefs(this)

        setupTimber()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        if (BuildConfig.DEBUG) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        @get:Synchronized
        lateinit var instance: App
            private set
    }
}