package com.android.pokekmp.android.di

import com.android.pokekmp.android.ui.PokemonAndroidViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { PokemonAndroidViewModel(get()) }
}
