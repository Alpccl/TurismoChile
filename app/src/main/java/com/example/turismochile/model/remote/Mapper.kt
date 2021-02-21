package com.example.turismochile.model.remote

import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity
import com.example.turismochile.model.remote.pojo.WrapperRegiones
import com.example.turismochile.model.remote.pojo.WrapperTurismo


fun fromInternetToRegionEntity(wrapper: List<WrapperRegiones>): List<RegionEntity> {
    return wrapper.map {
        RegionEntity(id = it.id, scrImage = it.image ) }
}
fun fromInternetToTuristEntity(wrapper: List<WrapperTurismo>): List<TurismEntity> {
    return wrapper.map {
        TurismEntity(id = it.id ,description = it.description,image = it.image,video = it.video) }
}