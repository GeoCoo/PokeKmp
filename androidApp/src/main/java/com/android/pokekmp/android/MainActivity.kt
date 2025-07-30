package com.android.pokekmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.pokekmp.android.ui.PokemonAndroidViewModel
import com.android.pokekmp.android.ui.PokemonScreen
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {
    private val viewModel: PokemonAndroidViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonScreen(viewModel)
        }
    }
}