package com.example.turismochile.model.remote

import com.example.turismochile.model.remote.pojo.WrapperRegiones
import com.example.turismochile.model.remote.pojo.WrapperTurismo
import okhttp3.Response
import retrofit2.http.GET



interface ApiInterface {

@GET("regiones")
suspend fun fetchRegionsList(): Response<WrapperRegiones>

    @GET("regiones")
suspend fun fetchTurismoList(): Response<WrapperTurismo>

}