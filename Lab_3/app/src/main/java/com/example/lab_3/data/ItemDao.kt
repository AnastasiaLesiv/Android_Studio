package com.example.lab_3.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao { // Dao для взаємодії з базою даних (Data Access Object)

    @Query("SELECT COUNT(*) FROM items")
    suspend fun getItemCount(): Int

    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<ItemEntity>

    @Insert
    suspend fun insertItem(item: ItemEntity)

    @Query("DELETE FROM items")
    suspend fun deleteAllItems()
}
