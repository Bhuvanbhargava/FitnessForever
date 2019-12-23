package edu.bellevue.bhuvan.weighttracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.bellevue.bhuvan.database.IWeightDao


class WeightTrackerViewModalFactory(
    private val dataSource:IWeightDao,
    private val application: Application,
    private val weightVal: String,private val dateVal:String)
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        if (modelClass.isAssignableFrom(WeightTrackerViewModal::class.java)) {
            return WeightTrackerViewModal(dataSource, application,weightVal,dateVal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}