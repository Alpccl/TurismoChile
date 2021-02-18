package com.example.turismochile.model.remote.pojo


import com.google.gson.annotations.SerializedName

data class Regionespojo(
    @SerializedName("Regiones")
    val wrapperRegiones: List<WrapperRegiones>,
    @SerializedName("Turismo")
    val wrapperTurismo: List<WrapperTurismo>
)