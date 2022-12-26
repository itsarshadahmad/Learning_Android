package com.example.roomanddatabase

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.*
import java.util.*

// RoomDb -> is abstraction over SQLite which less boilerplate code, process query at
// compile time. It offers entities, DAO (data access object), database, type
// convertors, migration. It is also flexible to allow us write sql queries also.
// Coroutines will be used to execute database operation on background thread.

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvShow = findViewById<TextView>(R.id.tvShow)

        database = ContactDatabase.getDatabase(this) // db instance

//         Executing on other thread
        CoroutineScope(Dispatchers.Default).launch {
            database.contactDao().insertContact(
                Contact(0, "Joe", "98765", Date())
            )
        }

        // Shows first user onClick show textview
        tvShow.setOnClickListener {
            database.contactDao().getContact().observe(this) {
                Log.d("DB_RESPONSE", "onCreate: $it")
                Toast.makeText(this, "${it[0].name} found.", Toast.LENGTH_LONG).show()
            }
        }
    }
}