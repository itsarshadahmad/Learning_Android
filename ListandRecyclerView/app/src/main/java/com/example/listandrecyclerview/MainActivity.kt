package com.example.listandrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        RecyclerView is listview but it doesn't pre allocate all views it only create views
//        which are visible on screen and render them with changing data on them as user scroll.
//        ViewHolder -> This will hold the view and helps in recycling.
//        Adapter -> This will adapt our data so that it can be displayed in a list. (it coverts
//        data, so recyclerview can display).
//        Layout Manager -> It tells how we want to position views horizontally, vertically,
//        and staggered list.
        val myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        setting layout manager to linear layout compatible manager
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val data = arrayOf(
            "Jaby",
            "Joe",
            "Tanmay",
            "Brandon",
            "Daniel",
            "Samantha",
            "Ross",
            "Taylor",
            "Kanye",
            "Robert",
            "Anderson"
        )
        myRecyclerView.adapter = ProgrammingAdapter(data)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}