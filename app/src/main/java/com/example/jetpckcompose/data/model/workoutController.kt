package com.example.jetpckcompose.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _workouts = MutableStateFlow<List<workout>>(emptyList())
    val workouts: StateFlow<List<workout>> get() = _workouts

    init {
        fetchWorkouts()
    }

    private fun fetchWorkouts() {
        db.collection("workouts")
            .get()
            .addOnSuccessListener { result ->
                val workoutList = result.documents.mapNotNull { document ->
                    document.toObject(workout::class.java)
                }
                _workouts.value = workoutList
            }
            .addOnFailureListener { e ->
            }
    }
}
