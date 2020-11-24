package com.example.roomexample

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomexample.database.Customer
import com.example.roomexample.database.DataRepository
import com.example.roomexample.database.MyDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var customer = Customer(1, "David", "Cachero")
        var dataRepository = DataRepository(this)
        dataRepository.insert(customer)
        var customers = GetCustomer(this).execute().get()
    }

    private class InsertCustomer(val context: Context) : AsyncTask<Customer, Void, Void>() {
        override fun doInBackground(vararg customer: Customer): Void? {
            var database = MyDatabase.getInstance(context)
            database!!.customerDao().insertAll(customer[0])
            return null
        }
    }

    private class GetCustomer(val context: Context) : AsyncTask<Void, Void, List<Customer>>() {
        override fun doInBackground(vararg p0: Void?): List<Customer> {
            var database = MyDatabase.getInstance(context)
            var customers = database!!.customerDao().getAll()
            //  var cus =  database!!.customerDao().select(1)
            return customers
        }
    }
}