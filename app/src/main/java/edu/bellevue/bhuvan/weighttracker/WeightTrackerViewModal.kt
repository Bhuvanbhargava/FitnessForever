package edu.bellevue.bhuvan.weighttracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import edu.bellevue.bhuvan.convertDateStringToLong

import edu.bellevue.bhuvan.database.IWeightDao
import edu.bellevue.bhuvan.database.Weight
import kotlinx.coroutines.*

class WeightTrackerViewModal(val database: IWeightDao,application: Application, val weightVal:String, val dateVal:String)
    :AndroidViewModel(application){
    private var viewModelJob= Job()
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    var date=convertDateStringToLong(dateVal)
    private val uiScope= CoroutineScope(Dispatchers.Main + viewModelJob)

    fun recordCurrentWeight(){
        uiScope.launch {
            val weight=  Weight(weight = weightVal,date=date)
            insert(weight)
        }
    }

    private suspend fun insert(weight: Weight) {
        withContext(Dispatchers.IO) {
            database.insert(weight)
        }
    }


}
