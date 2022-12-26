package com.example.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// LiveData is one of the android architecture components. LiveData is an observable
// data holder class. What is the meaning of observable here the observable means live
// data can be observed by other components like activity and fragments (Ui Controller).
// The most important thing about LiveData is it has the knowledge about the Life cycle
// of its observers like activity or fragment. That means Live data only updates the app
// components like Activity or Fragments which are in active life cycle state. LiveData
// notifies the observer(Activity or Fragment) which are in Started or Resumed life cycle
// state.

class MainViewModel : ViewModel() {
    private val counterLiveDataObject = MutableLiveData<Int>(0)
    private var counter = 0
    val counterLiveData: LiveData<Int>
        get() = counterLiveDataObject

    // Updating live data which will notify observer to act on changes.
    fun updateLiveData() {
        counter++
        counterLiveDataObject.value = counter
    }
}