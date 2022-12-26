package com.example.roomanddatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

// Entities -> Its class implementation of table. Each table has its own entities class.
// It gives table structure, and also allow us to assign value according like primary
// key id, and other values of relational database.

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val phone: String,
    val createdDate: Date,
    val isActive: Boolean
)
