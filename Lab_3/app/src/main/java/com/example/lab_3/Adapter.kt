package com.example.lab_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(private var items: List<ListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateData(newItems: List<ListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.title_1)
    }

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTextView: TextView = view.findViewById(R.id.text_1)
    }

    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_photo)
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ListItem.TitleItem -> TYPE_TITLE
            is ListItem.TextItem -> TYPE_TEXT
            is ListItem.PhotoItem -> TYPE_PHOTO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_TITLE -> TitleViewHolder(inflater.inflate(R.layout.item_title, parent, false))
            TYPE_TEXT -> TextViewHolder(inflater.inflate(R.layout.item_text, parent, false))
            TYPE_PHOTO -> PhotoViewHolder(inflater.inflate(R.layout.item_photo, parent, false))
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> {
                val item = items[position] as ListItem.TitleItem
                Log.d("Binding Title", "Position: $position, Title: ${item.title}")
                holder.titleTextView.text = item.title
            }
            is TextViewHolder -> {
                val item = items[position] as ListItem.TextItem
                Log.d("Binding Text", "Position: $position, Text: ${item.text}")
                holder.textTextView.text = item.text
            }
            is PhotoViewHolder -> {
                val item = items[position] as ListItem.PhotoItem
                Log.d("Binding Photo", "Position: $position, URL: ${item.imageUrl}")
                Glide.with(holder.imageView.context)
                    .load(item.imageUrl)
                    .into(holder.imageView)
            }
        }
    }


    override fun getItemCount(): Int = items.size

    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_TEXT = 1
        const val TYPE_PHOTO = 2
    }
}
