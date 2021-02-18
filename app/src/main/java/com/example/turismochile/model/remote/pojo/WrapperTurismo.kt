package com.example.turismochile.model.remote.pojo


import com.google.gson.annotations.SerializedName

data class WrapperTurismo(

    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("Video")
    val video: String,

)