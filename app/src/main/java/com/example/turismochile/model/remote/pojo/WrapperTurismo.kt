package com.example.turismochile.model.remote.pojo


import com.google.gson.annotations.SerializedName

data class WrapperTurismo(

    @SerializedName("id")
    val id: String,
    @SerializedName("descripcion")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("video")
    val video: String,

)