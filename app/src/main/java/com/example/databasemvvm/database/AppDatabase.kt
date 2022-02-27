package com.example.databasemvvm.database

import android.content.Context
import androidx.room.*
import com.example.databasemvvm.model.RepositoryData
import com.example.databasemvvm.model.TypeConverterOwner


@Database(entities = [RepositoryData::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterOwner::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getAppDao():AppDao
    companion object{
        private var DB_INSTANCE: AppDatabase? = null

        fun getAppDBInstance(context: Context): AppDatabase{
            if(DB_INSTANCE == null){
                DB_INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "APP_DB")
                    .allowMainThreadQueries()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }
}