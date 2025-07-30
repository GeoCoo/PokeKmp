package com.android.pokekmp.android

import android.app.Application
import com.android.pokekmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(sharedModule)
        }
    }
}
