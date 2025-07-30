package com.android.pokekmp.mvi

sealed class PokemonIntent {
    object LoadPokemon : PokemonIntent()
}