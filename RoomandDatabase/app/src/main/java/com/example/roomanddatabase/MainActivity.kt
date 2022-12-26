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

// Db Migration -> When we update our database like made some changes added some, rows
// or columns in that case we migrate our db from one version to another version. Any
// changes can be said as db migration. In migration we have to make changes that
// doesn't break or risk previous users data. Like we added date field here so we want
// users who doesn't have date field their data and db work as other just might be that
// field functionality would be missing or assigned to null.

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
//                Contact(0, "Joe", "98765", Date())
                Contact(0, "Andrew", "98765", Date(), true)
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