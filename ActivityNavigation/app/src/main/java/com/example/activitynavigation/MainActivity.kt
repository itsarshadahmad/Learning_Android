package com.example.activitynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.activitynavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {

            applyBtn.setOnClickListener {
                val name = nameEditText.text.toString()
                val age = ageEditText.text.toString().toInt()
                val country = countryEditText.text.toString()
//                class way to pass intent data
                val person = Person(name, age, country)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    it.putExtra("NAME", name)
                    it.putExtra("AGE", age)
                    it.putExtra("COUNTRY", country)
                    // if we have to pass class data through intent
                    it.putExtra("PERSON", person)
                    startActivity(it)
                }
            }
        }
    }
}