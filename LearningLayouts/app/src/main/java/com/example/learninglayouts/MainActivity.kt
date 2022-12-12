package com.example.learninglayouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.learninglayouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Default way to populate layout
//        setContentView(R.layout.activity_main)

//        Way to get views but it does that on runtime that's why its costly process
//        R.id.firstNumEditText

//        data binding way to populate layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        binding.apply {
            addBtn.setOnClickListener {
                if (firstNumEditText.text.toString()
                        .isNotEmpty() && secondNumEditText.text.toString()
                        .isNotEmpty()
                ) {
                    val num1 = firstNumEditText.text.toString().toInt()
                    val num2 = secondNumEditText.text.toString().toInt()
                    resultTextView.text = (num1 + num2).toString()
                    resetView()
                }
            }

            subBtn.setOnClickListener {
                if (firstNumEditText.text.toString()
                        .isNotEmpty() && secondNumEditText.text.toString()
                        .isNotEmpty()
                ) {
                    val num1 = firstNumEditText.text.toString().toInt()
                    val num2 = secondNumEditText.text.toString().toInt()
                    resultTextView.setText(num1 + num2)
                    resetView()
                }
            }

            multiplyBtn.setOnClickListener {
                if (firstNumEditText.text.toString()
                        .isNotEmpty() && secondNumEditText.text.toString()
                        .isNotEmpty()
                ) {
                    val num1 = firstNumEditText.text.toString().toInt()
                    val num2 = secondNumEditText.text.toString().toInt()
                    resultTextView.setText(num1 * num2)
                    resetView()
                }
            }

            divBtn.setOnClickListener {
                if (firstNumEditText.text.toString()
                        .isNotEmpty() && secondNumEditText.text.toString()
                        .isNotEmpty()
                ) {
                    val num1 = firstNumEditText.text.toString().toInt()
                    val num2 = secondNumEditText.text.toString().toInt()
                    resultTextView.setText(num1 / num2)
                    resetView()
                }
            }
        }
    }

    private fun resetView() {
        binding.firstNumEditText.setText("")
        binding.secondNumEditText.setText("")
    }
}