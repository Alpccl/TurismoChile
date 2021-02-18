package com.example.turismochile.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.turismochile.model.remote.pojo.WrapperRegiones
import org.jetbrains.annotations.NotNull

@Entity(tableName = "region_table")
data class RegionEntity(
    @PrimaryKey
    @NotNull
    val region: WrapperRegiones,
    val scrImage: String
    )