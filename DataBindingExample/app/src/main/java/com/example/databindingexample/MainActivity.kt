package com.example.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingexample.databinding.ActivityMainBinding

// DataBinding -> It is a support library that allows you to bind UI components in
// your layouts to data sources in your app using a declarative format rather than
// programmatically. It also eliminates findViewById() which search for view at runtime
// which takes hit on performance specially in big complex apps. DataBinding gives
// views to activity at compile or build time.

// It generates binding class with layout name and binding mentioned at end to specify
// binding class. Using that we can inflate layout, work with variables which we create
// inside our layout. When we create object of it using DataBindingUtil class,
// we can access each views and variables of layout without findViewById() call. It
// is also help to keep layout associated with generated class so no need worry keeping
// different id for each view in every layout. ex- tvShow can exist inside binding of
// main activity and you can create same inside fragment show class. Each will be access
// by its own class binding object.

// It also introduce variable inside layout which allow us to set views values
// using variable, it is reference to data class which you create for variable.
// It does getter & setter by itself. You just need to initialize data class object
// by accessing binding object.

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            // Accessing dataBinding layout variable. Setting its field which will
            // populate layout.
            quote = Quote("Do, or do not. There is no try.", "Yoda")
        }
    }
}