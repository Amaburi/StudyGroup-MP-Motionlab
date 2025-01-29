package com.example.apijtpck.utils

import com.example.apijtpck.model.PokemonResponse
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon?limit=20") // Fetches first 10 Pokémon
    suspend fun getPokemons(): PokemonResponse
}
