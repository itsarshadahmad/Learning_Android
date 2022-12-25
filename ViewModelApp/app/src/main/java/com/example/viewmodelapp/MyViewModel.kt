package com.example.viewmodelapp

import androidx.lifecycle.ViewModel

class MyViewModel(var count: Int = 0) : ViewModel() {
//    var count: Int = 0

    fun increment() {
        count++
    }
}