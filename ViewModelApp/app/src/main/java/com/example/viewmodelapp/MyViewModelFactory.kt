package com.example.viewmodelapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// ViewModelFactory -> It is used when we require to send view model data or pass any
// value like context, value, etc. In that case we need create view model using factory
// class because view model automatically generates instance, to pass values we use
// factory class using predefined functions like create.

class MyViewModelFactory(private val counter: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(counter) as T
    }
}