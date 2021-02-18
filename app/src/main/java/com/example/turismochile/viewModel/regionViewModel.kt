package com.example.turismochile.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.turismochile.model.local.RegionDatabase
import com.example.turismochile.model.RegionRepository
import kotlinx.coroutines.launch

class regionViewModel (application: Application): AndroidViewModel(Application) {

private val repository : RegionRepository

init {
    val db = RegionDatabase.getDataBase(application)
    val daoRegion = db.daoRegion()
    val daoTurism = db.daoTurism()
    repository = RegionRepository(daoRegion, daoTurism)

    viewModelScope.launch {
        repository.
    }
}
    fun getRegionList() LiveData<List<RegionEntity>> = repository.regionListLiveData

    private var regionSelected : String = ""

    fun getImagesByRegionFRomInternet
}