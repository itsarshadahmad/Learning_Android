package com.example.networkcall

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    private val URL = "https://api.github.com/users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList: RecyclerView = findViewById(R.id.userList)
        userList.layoutManager = LinearLayoutManager(this)

//        StringRequest create network request where first param is URL, and second
//        param is Response.Listener it runs code on either successful response or
//        error response by running callback.
        val request = StringRequest(URL, { response ->
            // Success Callback onResponse(response)
//            Gson is a Java library that can be used to convert Java Objects into their
//            JSON representation. It can also be used to convert a JSON string to an
//            equivalent Java object.
//            Log.d("CODE", "onResponse:\n$response ")
            val gsonBuilder: GsonBuilder = GsonBuilder()
            val gson: Gson = gsonBuilder.create()
            val users = gson.fromJson(response, Array<User>::class.java).toList()
//            Log.d("CODE", "onResponse:\n${users[0]} ")
            userList.adapter = GithubAdapter(this@MainActivity, users.toTypedArray())
        }, { error ->
            // Error Callback onErrorResponse(error)
            Toast.makeText(this, "Something went wrong!\n$error", Toast.LENGTH_LONG).show()
        })

//        Then we have to string request inside request queue where check for cache of
//        request if exist then return cache else send request to network and return
//        result it also add result in cache.
//        Creating new request queue to add request inside queue
        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(request) // adding string request to queue
    }
}