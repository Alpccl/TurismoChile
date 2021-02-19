package com.example.turismochile.model.remote

import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity
import com.example.turismochile.model.remote.pojo.Regionespojo

fun fromInternetToRegionEntity(wrapper: Regionespojo): List<RegionEntity>{
    return wrapper.wrapperRegiones.map { RegionEntity(id = it.id, scrImage = it.image) }
}
fun fromInternetToTuristEntity(wrapper: Regionespojo): List<TurismEntity>{
    return wrapper.wrapperTurismo.map { TurismEntity(id = it.id, description = it.description,
        image = it.image, video = it.video) }
}