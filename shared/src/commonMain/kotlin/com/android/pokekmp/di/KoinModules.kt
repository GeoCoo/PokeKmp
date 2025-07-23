package com.android.pokekmp.di

import com.android.pokekmp.network.provideHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import io.ktor.client.*

val commonModule: Module = module {
    single<HttpClient> { provideHttpClient() }
    // Add more common services here
}