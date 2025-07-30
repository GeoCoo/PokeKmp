package com.android.pokekmp.network

import com.android.pokekmp.model.PokemonListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

const val BASE_URL = "https://pokeapi.co/api/v2/pokemon"

interface PokemonAPI {
    suspend fun getPokemonList(limit: Int = 5, offset: Int = 0): PokemonListResponse
}

class PokemonApiImpl(private val client: HttpClient) : PokemonAPI {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonListResponse {
        return client.get(BASE_URL) {
            url {
                parameters.append("limit", limit.toString())
                parameters.append("offset", offset.toString())
            }
        }.body()
    }
}