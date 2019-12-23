package edu.bellevue.bhuvan.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IFoodDao {
    @Query("SELECT * FROM Food where Date=:key")
    fun getFood(key:Long): LiveData<List<Food>>

    @Update
    fun update(vararg food: Food)

    @Insert
    fun insert(vararg food: Food)

    @Delete
    fun delete(food: Food)
}