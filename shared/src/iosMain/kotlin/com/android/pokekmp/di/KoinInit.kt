package com.android.pokekmp.di

import org.koin.core.context.startKoin

fun doInitKoin() {
    startKoin {
        modules(sharedModule)
    }
}