package com.android.pokekmp.mvi

data class PokemonState(
    val isLoading: Boolean = false,
    val names: List<String> = emptyList(),
    val error: String? = null
)