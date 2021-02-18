package com.example.turismochile.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.turismochile.model.local.entities.RegionEntity


@Dao
interface DaoRegion {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRegionList(listRegion: List<RegionEntity>)

    @Query("SELECT * FROM region_table")
    fun getAllRegionList(): LiveData<List<RegionEntity>>
}