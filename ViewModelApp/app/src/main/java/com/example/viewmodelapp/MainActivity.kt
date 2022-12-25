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

// Android Architecture Components (AAC) -> It is a new collection of libraries that
// contains the lifecycle-aware components. It can solve problems with configuration
// changes, supports data persistence, reduces boilerplate code, helps to prevent
// memory leaks and simplifies async data loading into your UI. I can’t say that it
// brings absolutely new approaches for solving these issues, but, finally, we have a
// formal, single and official direction.

// LifecycleObserver -> It is class which we create to observe UI lifecycle and write
// code accordingly. It also allows to write code outside of activity or fragment class.
// It is also base for view model to make data separate from UI events to avoid lost
// of data or any other bugs cause by activity or fragment lifecycle.

// LifecycleOwner -> Lifecycle of android is associate with its UI which is activity
// and fragment. It is also lifecycle owner which provide lifecycle to observer classes.
// Activity or fragment has its own lifecycle from creation to destruction of app or
// particular activity or fragment.

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
        // By populating view model or factory to populate data values. View Model
        // provider create or initialize view model class data and provides it
        // to views of our activity or fragment. It gives access of data which we
        // created inside view model class to activity or fragment like data, functions
        // etc.
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