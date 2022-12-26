package com.example.databindingandlivedataexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var counter = MutableLiveData<Int>(0)
    var twoWayTest = MutableLiveData<String>()
    private var count = 0

    fun updateCounter() {
        count++
        counter.value = count
    }
}