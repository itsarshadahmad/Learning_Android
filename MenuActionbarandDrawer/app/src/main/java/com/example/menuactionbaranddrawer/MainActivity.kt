package com.example.menuactionbaranddrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    // Actionbar drawer toggle -> Toggle button to open & close nav drawer
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Drawer layout to populate nav Drawer on display
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)

        // Toggle actionbar implementation/configuration
        toggle =
            ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState() // Ready to use

        // Shows back button when display home is enable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Navigation item select event
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miItem1 -> {
                    Toast.makeText(
                        applicationContext, "${it.title} clicked.", Toast.LENGTH_LONG
                    ).show()
                }
                R.id.miItem2 -> {
                    Toast.makeText(
                        applicationContext, "${it.title} clicked.", Toast.LENGTH_LONG
                    ).show()
                }
                R.id.miItem3 -> {
                    Toast.makeText(
                        applicationContext, "${it.title} clicked.", Toast.LENGTH_LONG
                    ).show()
                }
                R.id.miItem4 -> {
                    Toast.makeText(
                        applicationContext, "${it.title} clicked.", Toast.LENGTH_LONG
                    ).show()
                }
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // inflates menu to screen
        menuInflater.inflate(R.menu.app_bar_menu, menu)
//        return super.onCreateOptionsMenu(menu)
        return true
    }

    // Act on menu item click of navigation drawer as well as app bar menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Nav drawer options
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

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
    }
}