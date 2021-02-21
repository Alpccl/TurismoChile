package com.example.turismochile.model.remote


import com.example.turismochile.model.remote.pojo.Regionespojo
import retrofit2.Response

import retrofit2.http.GET



interface ApiInterface {

@GET("regiones")
suspend fun fechRegionCorroutines(): Response<Regionespojo>

}