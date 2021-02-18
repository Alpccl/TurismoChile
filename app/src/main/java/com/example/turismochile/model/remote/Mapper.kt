package com.example.turismochile.model.remote

import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity
import com.example.turismochile.model.remote.pojo.Regionespojo

fun fromInternetToRegionEntity(wrapper: Regionespojo): List<RegionEntity>{
    return wrapper.regiones.map { RegionEntity(region = it)}
}
fun fromInternetToTuristEntity(wrapper: Regionespojo): List<TurismEntity>{
    return wrapper.wrapperTurismo.map{ TurismEntity(id = it)}
}