package com.example.roomanddatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// DAO -> database access object is used as interface to access database items,
// perform CRUD operations. We can have multiple DAOs. Its declare interface because
// its implementation will be filled by roomDB.

@Dao
interface ContactDAO {
    // suspend will execute query on background thread
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    // we define list as live data to executes query in background thread
    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<Contact>>
}