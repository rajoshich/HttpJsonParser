package com.rajoshich.httpjsonparser

import android.app.Application

class HttpApp: Application() {
    lateinit var apiManager: ApiManager
    override fun onCreate() {
        super.onCreate()
        apiManager = ApiManager(this)
    }

}
