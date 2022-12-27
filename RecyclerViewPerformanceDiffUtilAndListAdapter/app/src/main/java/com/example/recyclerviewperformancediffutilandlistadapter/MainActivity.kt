package com.example.recyclerviewperformancediffutilandlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvList = findViewById<RecyclerView>(R.id.rvList)

        val data = mutableListOf<Contact>()
        data.add(Contact("Joe", "456878"))
        data.add(Contact("Roman", "125874"))
        data.add(Contact("Dan", "659875"))
        data.add(Contact("Sean", "789654"))
        data.add(Contact("Eddie", "236548"))

        val adapter = MyAdapter()
        adapter.submitList(data) // Submitting data to recyclerView

        rvList.layoutManager = LinearLayoutManager(this)
        rvList.setHasFixedSize(true)
        rvList.adapter = adapter

        // Changes List after 4sec timeout
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val data1 = mutableListOf<Contact>()
                data1.add(Contact("Joe", "456878"))
                data1.add(Contact("Jeff", "125874"))
                data1.add(Contact("Mike", "659875"))
                data1.add(Contact("Sean", "789654"))
                data1.add(Contact("Andrew", "996648"))
                data1.add(Contact("Eddie", "236548"))
                adapter.submitList(data1)
            }, 4000
        )
    }
}