package com.android.pokekmp.android

import android.app.Application
import com.android.pokekmp.di.commonModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(commonModule)
        }
    }
}
