package com.example.roomtut.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MarkerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMarker(marker: Marker)

    @Query("SELECT * FROM marker_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Marker>>
}