package com.example.networkcall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class GithubAdapter(context: Context, data: Array<User>) :
    RecyclerView.Adapter<GithubAdapter.GithubViewHolder>() {

    private var data: Array<User>
    private var context: Context

    init {
        this.context = context
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_user_layout, parent, false)
        return GithubViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val user: User = data[position]
        holder.txtUser.text = user.login
        Glide.with(holder.imgUser.context).load(user.avatarUrl).into(holder.imgUser)
//        To listen onClick use holder.itemView to make all views of that list click event
        holder.itemView.setOnClickListener {
            Snackbar.make(it, "${user.login}", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class GithubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgUser: ImageView
        var txtUser: TextView

        init {
            imgUser = itemView.findViewById<ImageView>(R.id.imgUser)
            txtUser = itemView.findViewById<TextView>(R.id.txtUser)
        }
    }
}