package com.example.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

// Live data acts when data changes of type live data so observers get notify about
// changes and act accordingly.

class MainActivity : AppCompatActivity() {
    // Getter way to set layout
    private val tvShow: TextView
        get() = findViewById(R.id.tvShow)
    private val btnUpdate: Button
        get() = findViewById(R.id.btnUpdate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // Observing counterLiveData object for any changes to reflect.
        mainViewModel.counterLiveData.observe(this) {
            tvShow.text = it.toString()
        }

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }
    }
}