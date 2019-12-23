package edu.bellevue.bhuvan.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IWeightDao {
    @Query("SELECT * FROM weight")
    fun getAll(): LiveData<List<Weight>>

    @Update
    fun update(vararg weight: Weight)

    @Insert
    fun insert(vararg weight: Weight)

    @Delete
    fun delete(weight: Weight)
}