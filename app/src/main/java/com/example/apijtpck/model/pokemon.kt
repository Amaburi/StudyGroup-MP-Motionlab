package com.example.apijtpck.model

data class Pokemon(
    val name: String,
    val url: String
)

data class PokemonResponse(
    val results: List<Pokemon>
)