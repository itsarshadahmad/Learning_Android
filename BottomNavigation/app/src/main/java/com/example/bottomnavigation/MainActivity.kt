package com.example.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        // Setting first fragment as default at app start
        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miMessages -> setCurrentFragment(secondFragment)
                R.id.miProfile -> setCurrentFragment(thirdFragment)
            }
            true
        }

        // Create number badge for message icon
        bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply {
            number = 10 // 10 messages
            isVisible = true
        }
    }

    // Set fragments to frame layout at runtime
    private fun setCurrentFragment(fragment: Fragment) {
        // Start transition to switch
        supportFragmentManager.beginTransaction().apply {
            // replace frame layout current fragment by new passed fragment
            replace(R.id.flFragment, fragment)
            commit() // saving changes
        }
    }
}
