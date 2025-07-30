package com.android.pokekmp.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.pokekmp.mvi.PokemonIntent

@Composable
fun PokemonScreen(viewModel: PokemonAndroidViewModel) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(PokemonIntent.LoadPokemon)
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
