package com.example.mvvm

import android.app.Application
import org.koin.core.context.startKoin

class MainApplication: Application() {
    companion object{
        lateinit var sInstant : MainApplication
    }

    override fun onCreate() {
        super.onCreate()
       sInstant = this
        startKoin {

        }

    }
}