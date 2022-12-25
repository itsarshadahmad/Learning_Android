package com.example.listandrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// Adapter sets all configuration and data to recyclerview so it can recycle and show views
class ProgrammingAdapter(data: Array<String>) :
    RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder>() {
    private var data: Array<String>

    init {
        this.data = data
    }

    // It creates view holder, store reference of view, and view holder stores our views
    // It execute at creation time of views.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        // Layout Inflater return view object corresponding to layout views
        val inflater = LayoutInflater.from(parent.context) // passing context from parent view group
        val view: View = inflater.inflate(R.layout.list_item_layout, parent, false)
        return ProgrammingViewHolder(view) // Passing views to view holder class
    }

    // It set data to views or View holder
    // It call function again & again to populate data on views.
    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val title = data[position]
        holder.textTitle.text = title
        holder.textTitle.setOnClickListener { v ->
            Toast.makeText(v.context, "View: $title", Toast.LENGTH_SHORT).show()
        }
    }

    // It tell size of data recyclerview will receive
    override fun getItemCount(): Int {
        return data.size
    }

    class ProgrammingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon: ImageView
        var textTitle: TextView

        init {
            imgIcon = itemView.findViewById(R.id.imgIcon)
            textTitle = itemView.findViewById(R.id.textTitle)
        }
    }
}