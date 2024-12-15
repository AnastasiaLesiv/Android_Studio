package com.example.lab_3.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<ItemEntity>

    @Insert
    suspend fun insertItems(items: List<ItemEntity>)

    @Query("DELETE FROM items")
    suspend fun deleteAllItems()
}
