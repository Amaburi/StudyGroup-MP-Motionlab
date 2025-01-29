package com.example.apijtpck.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apijtpck.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PokemonViewModel : ViewModel() {
    private val _pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = _pokemons

    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.instance.getPokemons()
                println("API Response: ${response.results}") // Debug log
                _pokemons.value = response.results
            } catch (e: Exception) {
                println("Error fetching Pokémon: ${e.message}")
                e.printStackTrace()
            }
        }
    }

}
