package com.example.flightsearch.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel


enum class FlightSearchScreens {
    Destinations,
    Favorites
}

@Composable
fun FlightSearchApp(
    viewModel: FlightSearchViewModel = viewModel(factory = FlightSearchViewModel.factory)
) {
    val destinations = viewModel.getDestinations(1).collectAsState(emptyList())
    Text(text = destinations.toString())
}