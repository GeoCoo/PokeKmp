package com.android.pokekmp.di

import com.android.pokekmp.network.PokemonApiImpl
import com.android.pokekmp.mvi.PokemonViewModel
import com.android.pokekmp.network.PokemonAPI
import com.android.pokekmp.repository.PokemonRepository
import com.android.pokekmp.repository.PokemonRepositoryImpl
import com.android.pokekmp.useCase.GetPokemonListUseCase
import com.android.pokekmp.useCase.GetPokemonListUseCaseImpl
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


expect fun provideHttpClient(): HttpClient

val sharedModule: Module = module {
    single { provideHttpClient() }
    singleOf(::PokemonApiImpl) { bind<PokemonAPI>() }
    singleOf(::PokemonRepositoryImpl) { bind<PokemonRepository>() }
    singleOf(::GetPokemonListUseCaseImpl) { bind<GetPokemonListUseCase>() }
    single { PokemonViewModel(get()) }
}
