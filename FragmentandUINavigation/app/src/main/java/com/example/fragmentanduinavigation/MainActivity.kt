package com.example.fragmentanduinavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// Fragment -> UI component which is reusable, its modular section of activity. It has
// its own lifecycle and lightweight than activity. Activity can host one or more
// fragment. Fragment are dependent on activity. It has its own view, fragment class.
// We can have static fragment with fixed fragment on activity or dynamic fragment that
// can change dynamically (add, remove, replace).

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing fragments
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnFragment2)

        // To add fragment in frame layout, we have to add fragment transaction
        supportFragmentManager.beginTransaction().apply {
            // It is used replace current fragment with other fragment, if we don't have
            // fragment in layout then it will add it.
            replace(R.id.flFragment, firstFragment)
            commit() // to reflect changes
        }

        // Setting fragment to change on click
        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                // If want to have back button for previous screen feature
                addToBackStack(null) // unique name for backstack but pass null to skip
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}