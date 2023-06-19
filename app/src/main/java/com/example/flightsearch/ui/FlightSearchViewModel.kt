package com.example.flightsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightSearchApplication
import com.example.flightsearch.data.Airport
import com.example.flightsearch.data.FlightSearchDao
import kotlinx.coroutines.flow.Flow

class FlightSearchViewModel(private val flightSearchDao: FlightSearchDao): ViewModel() {
    fun getDestinations(id : Int): Flow<List<Airport>> =
        flightSearchDao.getDestinationsFromDepartureAirport(id)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (
                        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                                as FlightSearchApplication
                        )
                FlightSearchViewModel(application.database.flightSearchDao())
            }
        }
    }
}