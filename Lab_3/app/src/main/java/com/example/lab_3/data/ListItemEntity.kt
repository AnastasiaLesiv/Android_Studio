package com.example.lab_3.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_items")
data class ListItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: Int, // Тип елемента: 0 - Title, 1 - Text, 2 - Photo
    val title: String?,
    val text: String?,
    val imageResId: Int?
)