package com.example.roomanddatabase

import androidx.room.TypeConverter
import java.util.Date

// Room provides functionality for converting between primitive and boxed types but
// doesn't allow for object references between entities. This document explains how to
// use type converters and why Room doesn't support object references.

// SQLite support on few types of data, so to work with other types we require to
// create type converters which acts like helper to store data db desired way and also
// return us in our desired way.

class Converters {

    @TypeConverter
    fun fromDateToLong(date: Date): Long = date.time

    @TypeConverter
    fun fromLongToDate(long: Long): Date = Date(long)

    @TypeConverter
    fun fromBooleanToInt(bool: Boolean): Int = if (bool) 1 else 0

    @TypeConverter
    fun fromIntToBoolean(integer: Int): Boolean = integer == 0
}