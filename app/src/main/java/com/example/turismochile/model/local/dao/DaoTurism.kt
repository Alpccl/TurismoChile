package com.example.turismochile.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.turismochile.model.local.entities.TurismEntity

@Dao
interface DaoTurism {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTurismoList(ListTurist : List<TurismEntity>)

    @Query("SELECT * FROM turism_table")
    fun getAllTuristList(): LiveData<List<TurismEntity>>

    @Query("SELECT * FROM turism_table WHERE id =:id")
    fun getInformationById(id: String): LiveData<TurismEntity>

}