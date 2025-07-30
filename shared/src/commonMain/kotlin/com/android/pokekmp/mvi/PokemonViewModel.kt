package com.android.pokekmp.mvi

import androidx.lifecycle.viewModelScope
import com.android.pokekmp.mvi.Effect.ShowError
import com.android.pokekmp.mvi.Event.LoadPokemon
import com.android.pokekmp.useCase.GetPokemonListUseCase
import kotlinx.coroutines.launch

data class State(
    val isLoading: Boolean = true,
    val names: List<String> = emptyList(),
    val error: String? = null
) : ViewState

// Event
sealed class Event : ViewEvent {
    object LoadPokemon : Event()
}

// Effect
sealed class Effect : ViewSideEffect {
    data class ShowError(val message: String) : Effect()
}

class PokemonViewModel(private val getPokemonListUseCase: GetPokemonListUseCase) :
    MviViewModel<Event, State, Effect>() {

    override fun setInitialState() = State(
        isLoading = true
    )


    override fun handleEvents(event: Event) {
        when (event) {
            is LoadPokemon -> {
                viewModelScope.launch {
                    try {
                        val response = getPokemonListUseCase()
                        setState {
                            copy(
                                isLoading = false,
                                names = response.results.map { it.name })
                        }
                    } catch (e: Exception) {
                        setState { copy(isLoading = false, error = e.message) }
                        setEffect { ShowError(e.message ?: "Unknown error") }
                    }
                }
            }
        }
    }

}