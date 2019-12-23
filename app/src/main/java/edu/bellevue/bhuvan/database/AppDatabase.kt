package edu.bellevue.bhuvan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Weight::class,Food::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun weightDao(): IWeightDao
    abstract fun foodDao(): IFoodDao
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "fitness_forever_db")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}