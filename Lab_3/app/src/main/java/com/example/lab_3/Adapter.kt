package com.example.lab_3

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.R

class Adapter(private var items: List<ListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newItems: List<ListItem>) { // Метод для оновлення даних
        items = newItems
        notifyDataSetChanged()
    }

    // ViewHolder для заголовка
    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.title_1)
    }

    // ViewHolder для тексту
    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTextView: TextView = view.findViewById(R.id.text_1)
    }

    // ViewHolder для фото
    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_photo)
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ListItem.TitleItem -> TYPE_TITLE
            is ListItem.TextItem -> TYPE_TEXT
            is ListItem.PhotoItem -> TYPE_PHOTO
            else -> throw IllegalArgumentException("Unknown type at position: $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_TITLE -> {
                val view = inflater.inflate(R.layout.item_title, parent, false)
                TitleViewHolder(view)
            }
            TYPE_TEXT -> {
                val view = inflater.inflate(R.layout.item_text, parent, false)
                TextViewHolder(view)
            }
            TYPE_PHOTO -> {
                val view = inflater.inflate(R.layout.item_photo, parent, false)
                PhotoViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("Adapter", "Binding item at position: $position, type: ${getItemViewType(position)}")
        when (holder) {
            is TitleViewHolder -> {
                val item = items[position] as ListItem.TitleItem
                holder.titleTextView.text = item.title
                Log.d("Adapter", "Title: ${item.title}")
            }
            is TextViewHolder -> {
                val item = items[position] as ListItem.TextItem
                holder.textTextView.text = item.text
                Log.d("Adapter", "Text: ${item.text}")
            }
            is PhotoViewHolder -> {
                val item = items[position] as ListItem.PhotoItem
                holder.imageView.setImageResource(item.imageResId)
                Log.d("Adapter", "Photo resource ID: ${item.imageResId}")
            }
        }
    }

    override fun getItemCount(): Int { // Метод для отримання кількості елементів у списку
        Log.d("Adapter", "Item count: ${items.size}")
        return items.size
    }

    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_TEXT = 1
        const val TYPE_PHOTO = 2
    }

}
