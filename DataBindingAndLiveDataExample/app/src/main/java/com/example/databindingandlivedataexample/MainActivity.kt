package com.example.databindingandlivedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingandlivedataexample.databinding.ActivityMainBinding

// Binding can be done in two way:
// One way binding -> When call happen and action are set in one way to reflect data mostly
// to show from view model class to layout.

// Two way binding -> Data flows in both direction it also sets or call data from layout
// and also layout send changes like editText field change to reflect on else where. It
// is mostly done when your live data is reflecting your work more than one place.
// ex- One place it shows and from another its taking input and reflect changes there also.

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // When we use live data inside layout we need to pass lifecycle owner to
        // layout know about lifecycle owner class so it can work according to class
        // lifecycle and states. Because livedata is lifecycle aware it won't work
        // without setting up lifecycle owner to binding or observe inside activity.
        binding.lifecycleOwner = this

        // Giving layout variable access of ViewModelProvider instance. It can then
        // access all available public functions and objects.
        binding.mainViewModel = mainViewModel

    }
}