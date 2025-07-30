package com.android.pokekmp.mvi

import com.android.pokekmp.useCase.GetPokemonListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase
) {
    private val _state = MutableStateFlow(PokemonState())
    val state: StateFlow<PokemonState> = _state.asStateFlow()

    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    fun onIntent(intent: PokemonIntent) {
        when (intent) {
            is PokemonIntent.LoadPokemon -> fetchPokemon()
        }
    }

    private fun fetchPokemon() {
        viewModelScope.launch {
            _state.value = PokemonState(isLoading = true)
            try {
                val response = getPokemonListUseCase()
                _state.value = PokemonState(
                    isLoading = false,
                    names = response.results.map { it.name }
                )
            } catch (e: Exception) {
                _state.value = PokemonState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}