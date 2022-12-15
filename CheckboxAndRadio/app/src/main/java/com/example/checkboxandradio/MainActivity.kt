package com.example.checkboxandradio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import com.example.checkboxandradio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            btnOrder.setOnClickListener {
                // This will return id of radio button that was checked from radio group
                val checkedOrderButtonId = rgOptions.checkedRadioButtonId
                val orderItem = findViewById<RadioButton>(checkedOrderButtonId)
                val cheese = cbCheeze.isChecked
                val onions = cbOnions.isChecked
                val salad = cbSalad.isChecked
                val orderString = "You have ordered:\n" +
                        "${orderItem.text}\n" +
                        (if (cheese) "Cheese\n" else "") +
                        (if (onions) "Onions\n" else "") +
                        (if (salad) "Salad\n" else "")

                tvOrder.text = orderString
            }
        }
    }
}