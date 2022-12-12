package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var previousNumber = "0"
    private var currentNumber = "0"
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        binding.apply {
            acBtn.setOnClickListener { allClear() }
            delBtn.setOnClickListener { deleteLastNumber() }
        }
    }

    private fun allClear() {
        previousNumber = "0"
        currentNumber = "0"
        operator = ""
        updateDisplay()
    }

    private fun deleteLastNumber() {
        if (currentNumber != "0") {
            currentNumber = currentNumber.dropLast(1)
            updateDisplay()
        }
        if (currentNumber.isEmpty()) {
            currentNumber = "0"
        }
    }

    private fun updateDisplay() {
        if (operator == "=" && previousNumber != "0") {
            previousNumber = "0"
            operator = ""
        } else if (previousNumber == "0" && operator.isNotEmpty()) {
            previousNumber = currentNumber
            currentNumber = "0"
        }
        binding.resultTextView.text = currentNumber
    }

    fun addOperationToScreen(view: View) {
        binding.apply {
            val displayNumber = when (view.id) {
                oneBtn.id -> oneBtn.text.toString()
                twoBtn.id -> twoBtn.text.toString()
                threeBtn.id -> threeBtn.text.toString()
                fourBtn.id -> fourBtn.text.toString()
                fiveBtn.id -> fiveBtn.text.toString()
                sixBtn.id -> sixBtn.text.toString()
                sevenBtn.id -> sevenBtn.text.toString()
                eightBtn.id -> eightBtn.text.toString()
                nineBtn.id -> nineBtn.text.toString()
                zeroBtn.id -> zeroBtn.text.toString()
//                decimalBtn.id -> decimalBtn.text.toString()
                else -> "error"
            }
            currentNumber += displayNumber
            updateDisplay()
            Log.d("CURRENT NUMBER", "MAIN ACTIVITY - addOperationToScreen: $currentNumber")
        }
    }

    fun operatorFunctionality(view: View) {
        binding.apply {
            when (view.id) {
                addBtn.id -> {
                    operator = addBtn.text.toString()
                    calculate(operator)
                }
                minusBtn.id -> {
                    operator = minusBtn.text.toString()
                    calculate(operator)
                }
                multiplyBtn.id -> {
                    operator = multiplyBtn.text.toString()
                    calculate(operator)
                }
                divBtn.id -> {
                    operator = divBtn.text.toString()
                    calculate(operator)
                }
                equalsBtn.id -> {
                    calculate(operator)
                    previousNumber = "0"
                    operator = ""
                    updateDisplay()
                }
            }
        }
    }

    private fun calculate(operator: String) {
        if (previousNumber != "0" && currentNumber != "0") {
            val prevNum = previousNumber.toInt()
            val currentNum = currentNumber.toInt()
            currentNumber = when (operator) {
                "+" -> {
                    previousNumber = currentNumber
                    currentNumber = "0"
                    (prevNum + currentNum).toString()
                }
                "-" -> {
                    previousNumber = currentNumber
                    currentNumber = "0"
                    (prevNum - currentNum).toString()
                }
                "x" -> {
                    previousNumber = currentNumber
                    currentNumber = "0"
                    (prevNum * currentNum).toString()
                }
                "÷" -> {
                    previousNumber = currentNumber
                    currentNumber = "0"
                    (prevNum / currentNum).toString()
                }
                else -> "Error"
            }
        }
        updateDisplay()
    }
}