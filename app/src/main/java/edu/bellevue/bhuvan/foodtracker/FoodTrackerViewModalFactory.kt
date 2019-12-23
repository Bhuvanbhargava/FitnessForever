package edu.bellevue.bhuvan.foodtracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.bellevue.bhuvan.database.IFoodDao
import edu.bellevue.bhuvan.database.IWeightDao

class FoodTrackerViewModalFactory(
    private val dataSource:IFoodDao,
    private val application: Application)
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        if (modelClass.isAssignableFrom(FoodTrackerViewModal::class.java)) {
            return FoodTrackerViewModal(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}