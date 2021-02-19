package com.example.turismochile.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.turismochile.model.remote.pojo.WrapperTurismo
import org.jetbrains.annotations.NotNull


@Entity(tableName = "turism_table")
data class TurismEntity(
    @PrimaryKey
    @NotNull
    val id: String,
    val description: String,
    val image: String,
    val video: String
)