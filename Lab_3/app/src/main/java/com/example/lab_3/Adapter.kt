package com.example.lab_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {

    // ViewHolder відповідає за представлення одного елемента списку
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val descriptionTextView: TextView = view.findViewById(R.id.item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Інфляція макету для одного елемента списку
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Прив'язка даних до ViewHolder
        val item = itemList[position]
        holder.titleTextView.text = item.title
        holder.descriptionTextView.text = item.description
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}