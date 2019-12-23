package edu.bellevue.bhuvan.database


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food (
    @PrimaryKey(autoGenerate = true)
    val food_id: Int,
    val Name: String,
    val Type:String,
    val Calories: Int,
    val Date:Long
)

