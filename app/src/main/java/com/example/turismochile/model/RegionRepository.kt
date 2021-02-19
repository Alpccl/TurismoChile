package com.example.turismochile.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.turismochile.model.local.dao.DaoRegion
import com.example.turismochile.model.local.dao.DaoTurism
import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity
import com.example.turismochile.model.remote.RetrofitInstance
import com.example.turismochile.model.remote.fromInternetToRegionEntity
import com.example.turismochile.model.remote.fromInternetToTuristEntity

class RegionRepository(private val region: DaoRegion, private val turism: DaoTurism) {


    private val networkService = RetrofitInstance.retrofitInstance()
    val regionList = region.getAllRegionList()
    val turismList = turism.getAllTuristList()

    suspend fun fetchRegion(){
        val service = kotlin.runCatching { networkService.fetchRegionsList() }
        service.onSuccess {
            when(it.code()){
                200 -> it.body()?.let {
                    region.insertListRegion(fromInternetToRegionEntity(it))
                    turism.insertAllTurismoList(fromInternetToTuristEntity(it))
                }
                else -> Log.d("REPO", "${it.code()} - ${it.errorBody()}")

            }
           }
        service.onFailure{
            Log.e("REPO", "${it.message}")
        }
    }


    fun getAllRegion(id: String) : LiveData<List<RegionEntity>>{
        return region.getAllRegionList()
    }


}