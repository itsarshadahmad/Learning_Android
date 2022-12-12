package com.example.listandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val users = arrayOf(
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
            "Anderson",
            "Sean",
            "Haytham",
            "Mandy",
            "Albert",
            "Robin"
        )

//        ListView allocates entire datasets to scrollable list views
        val myListView = findViewById<ListView>(R.id.listView)
//        it requires adapter to bridge data and layout. You can also use custom layout as list.
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        myListView.adapter = arrayAdapter // Setting adapter to listView
    }
}