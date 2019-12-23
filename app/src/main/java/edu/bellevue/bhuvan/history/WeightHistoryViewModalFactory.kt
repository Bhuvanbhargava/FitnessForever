package edu.bellevue.bhuvan.history

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.bellevue.bhuvan.database.IWeightDao


class WeightHistoryViewModalFactory(
    private val dataSource:IWeightDao,
    private val application: Application
   )
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        if (modelClass.isAssignableFrom(WeightHistoryViewModal::class.java)) {
            return WeightHistoryViewModal(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}