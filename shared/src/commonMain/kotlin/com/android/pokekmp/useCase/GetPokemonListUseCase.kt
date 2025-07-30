package com.android.pokekmp.useCase

import com.android.pokekmp.model.PokemonListResponse
import com.android.pokekmp.repository.PokemonRepository

interface GetPokemonListUseCase {
    suspend operator fun invoke(limit: Int = 5, offset: Int = 0): PokemonListResponse
}

class GetPokemonListUseCaseImpl(private val repository: PokemonRepository) : GetPokemonListUseCase {
    override suspend operator fun invoke(limit: Int, offset: Int): PokemonListResponse {
        return repository.getPokemonList(limit, offset)
    }
}