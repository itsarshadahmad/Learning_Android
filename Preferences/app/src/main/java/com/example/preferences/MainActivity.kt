package com.example.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.preferences.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Create shared preference -> giving name and mode
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit() // allow us to edit using editor object

        binding.apply {

            // Storing data in shared preference
            btnSave.setOnClickListener {
                val name = etName.text.toString()
                val age = etAge.text.toString().toInt()
                val isAdult = cbAdult.isChecked

                editor.apply {
                    // putString takes data as key value to store shared preferences
                    putString("name", name)
                    putInt("age", age)
                    putBoolean("isAdult", isAdult)
                    // It will save details inside shared preferences asynchronously
                    // commit() can also store but it does that synchronously.
                    apply()
                }
            }

            // Loading shared preference data
            btnLoad.setOnClickListener {
                val name = sharedPref.getString("name", null)
                val age = sharedPref.getInt("age", 0)
                val isAdult = sharedPref.getBoolean("isAdult", false)

                Snackbar.make(
                    this.root,
                    "Name: $name Age:$age Adult:$isAdult",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}