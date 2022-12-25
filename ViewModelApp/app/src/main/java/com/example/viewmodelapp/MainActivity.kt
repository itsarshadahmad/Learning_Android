package com.example.viewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

// ViewModel -> The purpose of ViewModel is to encapsulate the data for a UI controller
// to let the data survive configuration changes. For information about how to load,
// persist, and manage data across configuration changes, see Saved UI States.

// ViewModel is used to handle data which is inflated in views so it can set again itself
// when device rotates or configuration changes. Its lifecycle start when app runs and
// ends when app destroys (onCleared()).

// The ViewModel class allows data to survive configuration changes such as screen
// rotations. The so called UI-related data is a few different kinds of data, such as,
// data the user enters, data generated during runtime and data loaded from a database.

class MainActivity : AppCompatActivity() {

    private lateinit var tvCount: TextView
    private lateinit var btnPlus: Button
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCount = findViewById(R.id.tvCount)
        btnPlus = findViewById(R.id.btnPlus)
//        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        // ViewModelProvider -> It is used to give data access to view or activity.
        // By populating view model or factory to populate data values.
        myViewModel = ViewModelProvider(
            this, MyViewModelFactory(10)
        )[MyViewModel::class.java]

        setText()

        btnPlus.setOnClickListener {
            myViewModel.increment()
            setText()
        }
    }

    private fun setText() {
        tvCount.text = myViewModel.count.toString()
    }
}