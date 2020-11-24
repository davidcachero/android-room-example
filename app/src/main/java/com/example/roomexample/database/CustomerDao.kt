package com.example.roomexample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer")
    fun getAll(): List<Customer>

    @Query("SELECT * FROM customer WHERE id = :CustomerId")
    fun select(CustomerId: Int): Customer

    @Insert
    fun insertAll(vararg customer: Customer)


}