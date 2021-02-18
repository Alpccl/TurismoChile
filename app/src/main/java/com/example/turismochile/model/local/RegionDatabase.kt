package com.example.turismochile.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.turismochile.model.local.dao.DaoRegion
import com.example.turismochile.model.local.dao.DaoTurism
import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity

@Database(entities = [RegionEntity::class, TurismEntity::class], version = 1)

abstract class RegionDatabase : RoomDatabase(){

    abstract fun daoRegion(): DaoRegion
    abstract fun daoTurism(): DaoTurism

    companion object{
        @Volatile
        private var INSTANCE: RegionDatabase? = null

        fun getDataBase(context: Context): RegionDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RegionDatabase::class.java,
                    "regions_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}