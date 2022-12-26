package com.example.roomanddatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// Database -> This will create database. Its implementation will be added by room.
// contact is passed as array which will create multiple table in our db. We also
// link our dao with entities and database.
@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class) // To setup type converter class to db class
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO

    // Singleton design pattern
    companion object {

        // When user install app for first time or doesn't have db then it will not
        // execute migration it will create v2 directly.
        // Migration object has all changes
        // Migration from v1 to v2
        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Executes (SQL query) during migration of previous users
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        // Volatile annotation will notify when contact instance is available or changes

        @Volatile
        private var contactInstance: ContactDatabase? = null

        // build database instance object, if already build then return object
        fun getDatabase(context: Context): ContactDatabase {
            if (contactInstance == null) {
                // Synchronized block will allow to stay in sync when multiple calls
                // happen. To avoid creating multiple instance of database.
                synchronized(this) {
                    contactInstance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB"
                    ).addMigrations(migration_1_2) // Migration added
                        .build()
                }
            }
            return contactInstance!!
        }
    }
}