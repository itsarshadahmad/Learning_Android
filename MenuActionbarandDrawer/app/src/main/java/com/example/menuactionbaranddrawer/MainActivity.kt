package com.example.menuactionbaranddrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // inflates menu to screen
        menuInflater.inflate(R.menu.app_bar_menu, menu)
//        return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Act on each item click event
        when (item.itemId) {
            R.id.miAddContact -> Toast.makeText(
                this, "You clicked on ${item.title}.", Toast.LENGTH_SHORT
            ).show()
            R.id.miClose -> finish()
            R.id.miFeedback -> Toast.makeText(
                this, "You clicked on ${item.title}.", Toast.LENGTH_SHORT
            ).show()
            R.id.miSettings -> Toast.makeText(
                this, "You clicked on ${item.title}.", Toast.LENGTH_SHORT
            ).show()
            R.id.miFavorites -> Toast.makeText(
                this, "You clicked on ${item.title}.", Toast.LENGTH_SHORT
            ).show()
        }

        return true
//        return super.onOptionsItemSelected(item)
    }
}