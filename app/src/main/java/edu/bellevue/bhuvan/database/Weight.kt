package edu.bellevue.bhuvan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Weight")
data class Weight(
    @PrimaryKey(autoGenerate = true)
    var weightId: Long = 0L,
    @ColumnInfo(name = "weightinlb")
    var weight: String ,
    @ColumnInfo(name = "insertdate")
    var date:Long
)