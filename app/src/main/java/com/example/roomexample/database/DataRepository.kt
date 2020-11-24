package com.example.roomexample.database

import android.content.Context
import android.os.AsyncTask

class DataRepository(context: Context) {
    private val customerDao: CustomerDao? = MyDatabase.getInstance(context)?.customerDao()

    fun insert(customer: Customer) {
        // val customerDao: CustomerDao? = MyDatabase.getInstance(context)?.customerDao()
        InsertCustomer(customerDao!!).execute(customer)
    }

    private class InsertCustomer(private val customerDao: CustomerDao) : AsyncTask<Customer, Void, Void>() {
        override fun doInBackground(vararg customer: Customer): Void? {
            customerDao.insertAll(customer[0])
            return null
        }
    }

}