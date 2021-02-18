package com.example.turismochile.model

import android.util.Log
import com.example.turismochile.model.local.dao.DaoRegion
import com.example.turismochile.model.local.dao.DaoTurism
import com.example.turismochile.model.remote.RetrofitInstance
import com.example.turismochile.model.remote.fromInternetToRegionEntity
import com.example.turismochile.model.remote.fromInternetToTuristEntity

class RegionRepository (private val daoRegion: DaoRegion, private val daoTurism: DaoTurism) {
    private val networkService = RetrofitInstance.retrofitInstance()
    val regionListLiveData:

    suspend fun fetchRegion(){
        val service = kotlin.runCatching { networkService.fetchRegionsList() }
        service.onSuccess{
            when(it.code()){
                200 -> it.body()?.let{
                    daoRegion.insertAllRegionList(fromInternetToRegionEntity(it))
                }
                else -> Log.d("REPO", "${it.code()} - ${it.errorBody()}"

            }
        }
        service.onFailure{
            Log.e("REPO", "${it.message}")
        }
    }
    suspend fun fetchTurism(){
        val service = kotlin.runCatching { networkService.fetchTurismoList() }
        service.onSuccess{
            when(it.code()){
                200 -> it.body()?.let{
                    daoTurism.insertAllTurismoList(fromInternetToTuristEntity(it))
                }
                else -> Log.d("REPO_TURIST", "${it.code()} - ${it.errorBody()}")
            }
        }
        service.onFailure{
            Log.d("REPO", "${it.message}")
        }
    }

    fun
}