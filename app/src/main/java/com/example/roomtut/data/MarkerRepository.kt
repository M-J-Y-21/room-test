package com.example.roomtut.data

import androidx.lifecycle.LiveData

class MarkerRepository(private val markerDao: MarkerDao) {

    val readAllData: LiveData<List<Marker>> = markerDao.readAllData()

    suspend fun addMarker(marker: Marker) {
        markerDao.addMarker(marker)
    }
}