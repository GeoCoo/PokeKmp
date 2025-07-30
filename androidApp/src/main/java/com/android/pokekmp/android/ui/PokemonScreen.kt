package com.android.pokekmp.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.pokekmp.mvi.Event
import com.android.pokekmp.mvi.PokemonViewModel
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject
import kotlin.getValue

@Composable
fun PokemonScreen() {
    val viewModel: PokemonViewModel by inject(PokemonViewModel::class.java)
    val state = viewModel.viewState.value

    LaunchedEffect(Unit) {
        viewModel.setEvent(Event.LoadPokemon)
    }

    when {
        state.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.error != null -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: ${state.error}")
            }
        }

        state.names.isNotEmpty() -> {
            Column(modifier = Modifier.padding(16.dp)) {
                state.names.forEach { name ->
                    Text(name)
                }
            }
        }

        else -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No Pokémon found.")
            }
        }
    }
}
