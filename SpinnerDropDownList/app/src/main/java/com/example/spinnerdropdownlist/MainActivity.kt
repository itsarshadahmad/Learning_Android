package com.example.spinnerdropdownlist

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spMonth = findViewById<Spinner>(R.id.spMonths)
        // Creating dynamic spinner
        val customList = arrayOf("first", "second", "third", "fourth")
        // ArrayAdapter convert array items to defined views (like listview, dropdown,etc)
        val adapter = ArrayAdapter(
            this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, customList
        )
        spMonth.adapter = adapter

        // Spinner events are handle by anonymous function
        spMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    parent?.getItemAtPosition(position).toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle scenarios when nothing is selected in dropdown list (spinner)
            }

        }
    }
}