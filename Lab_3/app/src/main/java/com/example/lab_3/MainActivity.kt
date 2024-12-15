package com.example.lab_3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.api.RetrofitClient
import com.example.lab_3.data.AppDatabase
import com.example.lab_3.data.ItemEntity
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Налаштування RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(emptyList())
        recyclerView.adapter = adapter

        // Отримуємо інстанс бази даних
        val db = AppDatabase.getDatabase(this)

        // Виконуємо завантаження даних
        lifecycleScope.launch {
            try {
                val apiResponse = RetrofitClient.apiService.getItems()
                val apiItems = apiResponse.products // Дістаємо масив із поля "products"

                val dbItems = apiItems.map { apiItem ->
                    ItemEntity(
                        title = apiItem.title,
                        description = apiItem.description,
                        imageUrl = apiItem.thumbnail
                    )
                }

                val db = AppDatabase.getDatabase(this@MainActivity)
                db.itemDao().deleteAllItems()
                db.itemDao().insertItems(dbItems)

                val items = db.itemDao().getAllItems()
                val listItems = items.map { entity ->
                    when {
                        entity.imageUrl.isNotEmpty() -> ListItem.PhotoItem(entity.imageUrl)
                        entity.description.isNotEmpty() -> ListItem.TextItem(entity.description)
                        else -> ListItem.TitleItem(entity.title)
                    }
                }
                adapter.updateData(listItems)
            } catch (e: Exception) {
                Log.e("MainActivity", "Помилка завантаження даних", e)
                Toast.makeText(this@MainActivity, "Помилка завантаження даних", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
