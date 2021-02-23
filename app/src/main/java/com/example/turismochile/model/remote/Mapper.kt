package com.example.turismochile.model.remote

import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity
import com.example.turismochile.model.remote.pojo.Regionespojo
import com.example.turismochile.model.remote.pojo.WrapperRegiones


fun fromInternetToRegionEntity(regionespojo: Regionespojo): List<RegionEntity> {
    return regionespojo.wrapperRegiones.map {
        RegionEntity(idRegiones = it.id, scrImage = it.image)}

}
fun fromInternetToTuristEntity(regionespojo: Regionespojo): List<TurismEntity> {
    return regionespojo.wrapperTurismo.map {
        TurismEntity(id = it.id ,description = it.description,image = it.image,video = it.video) }
}