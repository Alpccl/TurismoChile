package com.example.turismochile.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity
import retrofit2.http.GET


@Dao
interface DaoRegion {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRegion(listRegion: List<RegionEntity>)

    @Query("SELECT * FROM region_table")
    fun getAllRegionList(): LiveData<List<RegionEntity>>

    @Query("SELECT * FROM region_table WHERE id =:id")
    fun getInformationById(id: String): LiveData<RegionEntity>
}