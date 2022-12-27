package com.example.recyclerviewperformancediffutilandlistadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

// DiffUtil -> DiffUtil gives difference between two list or datasets. It gives option to compare list and act on changes
// accordingly. It gives differences between two list. So using listAdapter we can reflect changes on screen without
// refreshing entire recyclerView. If we don't use this then we have option of notifyOnDataSetChange() which refresh entire
// recyclerView and repaints data on views again. Because of that it take hit on performance when we call that's why
// DiffUtil is introduced and used to improve performance resolve this issue.

// ListAdapter -> It helps to adapt your list when data set changes without refreshing entire data of recyclerView. It also
// helps to integrate diffUtil and run process of comparison in background thread. (RecyclerView.ListAdapter)

// Here we need to put ListAdapter in place of RecyclerView.Adapter. It has same options with extra it take model as data
// class of your data which is reflected, viewHolderClass and DiffUtil class implementations object.
class MyAdapter : ListAdapter<Contact, MyAdapter.MyViewHolder>(DiffUtilCheck()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = getItem(position).name
        holder.tvContact.text = getItem(position).number
        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.purple_200)
            holder.tvName.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.white)
            )
            holder.tvContact.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.white)
            )
        }
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var tvName: TextView
        var tvContact: TextView

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvContact = itemView.findViewById(R.id.tvContact)
        }
    }

    // DiffUtil Class helps to check your data change state according to your own preference.
    class DiffUtilCheck : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            Log.d("Comparing_list", "areItemsTheSame: " + (oldItem.name == newItem.name))
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            Log.d("Comparing_list", "areContentsTheSame: " + (oldItem == newItem))
            return oldItem == newItem
        }
    }
}