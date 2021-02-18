package com.example.turismochile.model.remote.pojo


import com.google.gson.annotations.SerializedName

data class WrapperRegiones(

    @SerializedName(",id")
    val id: String,
    @SerializedName("image")
    val image: String
)