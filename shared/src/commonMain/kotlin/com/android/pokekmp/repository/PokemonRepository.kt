package com.android.pokekmp.repository

import com.android.pokekmp.model.PokemonListResponse
import com.android.pokekmp.network.PokemonAPI

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int = 5, offset: Int = 0): PokemonListResponse
}


class PokemonRepositoryImpl(private val api: PokemonAPI) : PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonListResponse {
        return api.getPokemonList(limit, offset)

    }

}