package com.android.pokekmp.android.ui

import androidx.lifecycle.ViewModel
import com.android.pokekmp.mvi.PokemonViewModel
import com.android.pokekmp.mvi.PokemonIntent
import com.android.pokekmp.mvi.PokemonState
import kotlinx.coroutines.flow.StateFlow

class PokemonAndroidViewModel(
    private val sharedViewModel: PokemonViewModel
) : ViewModel() {
    val state: StateFlow<PokemonState> = sharedViewModel.state
    fun onIntent(intent: PokemonIntent) = sharedViewModel.onIntent(intent)
}