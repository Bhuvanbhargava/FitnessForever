package edu.bellevue.bhuvan.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import androidx.lifecycle.Transformations

import edu.bellevue.bhuvan.database.IWeightDao

import edu.bellevue.bhuvan.formatWeight
import kotlinx.coroutines.*

class WeightHistoryViewModal(val database: IWeightDao, application: Application)
    : AndroidViewModel(application){

    private var viewModelJob= Job()
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope= CoroutineScope(Dispatchers.Main + viewModelJob)

    val allWeight = database.getAll()
    val weightString = Transformations.map(allWeight) { allWeight ->
        formatWeight(allWeight)
    }

}
