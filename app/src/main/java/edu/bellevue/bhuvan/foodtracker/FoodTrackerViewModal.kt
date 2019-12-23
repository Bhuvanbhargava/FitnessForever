package edu.bellevue.bhuvan.foodtracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import edu.bellevue.bhuvan.database.IFoodDao

import edu.bellevue.bhuvan.database.IWeightDao

class FoodTrackerViewModal(val database: IFoodDao,application: Application) :AndroidViewModel(application){
}