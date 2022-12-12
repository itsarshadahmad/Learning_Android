package com.example.activitynavigation

data class Person(
    val name: String,
    val age: Int,
    val country: String
) : java.io.Serializable

// To serialize an object means to convert its state to a byte stream so that the byte
// stream can be reverted back into a copy of the object. A Java object is serializable
// if its class or any of its superclasses implements either the java. io.