package com.example.roomanddatabase

import androidx.room.Database
import androidx.room.RoomDatabase

// Database -> This will create database. Its implementation will be added by room.
// contact is passed as array which will create multiple table in our db. We also
// link our dao with entities and database.
@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO
}
// its recommend to declared db class as singleton pattern to have one instance of db.