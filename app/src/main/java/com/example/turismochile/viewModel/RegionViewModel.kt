package com.example.turismochile.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.turismochile.model.local.RegionDatabase
import com.example.turismochile.model.RegionRepository
import com.example.turismochile.model.local.entities.RegionEntity
import com.example.turismochile.model.local.entities.TurismEntity
import kotlinx.coroutines.launch

 class RegionViewModel (application: Application): AndroidViewModel(application) {

private val repository : RegionRepository

init {
    val db = RegionDatabase.getDataBase(application)
    val daoRegion = db.daoRegion()
    val daoTurism = db.daoTurism()
    repository = RegionRepository(daoRegion, daoTurism)


    viewModelScope.launch {
        repository.fetchRegion()
    }
}
    fun getAllRegions() : LiveData<List<RegionEntity>> = repository.RegionListLiveData

    /*private var regionSelected : String = ""

    fun getRegionById(id : String) = viewModelScope.launch {
        regionSelected = id
        repository.getRegionByid(id)
    }*/

     fun getInformationById (id: String): LiveData<TurismEntity> {
         return repository.getInformationById(id)
     }
}