package com.example.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao

    companion object {
        private const val DATABASE_NAME = "customer_database"

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}