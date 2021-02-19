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
val allRegion: LiveData<List<RegionEntity>>
val allTurist: LiveData<List<TurismEntity>>

init {
    val db = RegionDatabase.getDataBase(application)
    val daoRegion = db.daoRegion()
    val daoTurism = db.daoTurism()
    repository = RegionRepository(daoRegion, daoTurism)
    allRegion = repository.regionList
    allTurist = repository.turismList
    viewModelScope.launch {
        repository.fetchRegion()
    }
}

    fun getRegionList(): LiveData<List<RegionEntity>> = repository.regionList

    private var regionSelected : String = ""

    fun getRegionByRegionFromInternet(region : String) = viewModelScope.launch {
        regionSelected = region
        repository.fetchRegion()
    }


     fun getInformationTurism(): LiveData<List<TurismEntity>> = repository.turismList
}