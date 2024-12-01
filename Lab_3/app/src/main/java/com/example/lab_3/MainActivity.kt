package com.example.lab_3

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.data.AppDatabase
import com.example.lab_3.data.ItemEntity
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Налаштовуємо RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(emptyList())
        recyclerView.adapter = adapter

        // Отримуємо доступ до бази даних
        val db = AppDatabase.getDatabase(this)

        lifecycleScope.launch {
            // Перевіряємо, чи пуста база даних
            val itemCount = db.itemDao().getItemCount()
            if (itemCount == 0) {
                // Якщо база пуста, додаємо початкові дані
                db.itemDao().insertItem(
                    ItemEntity(
                        title = "A6 e-tron",
                        description = "",
                        imageResId = 0
                    )
                )
                db.itemDao().insertItem(
                    ItemEntity(
                        title = "",
                        description = "Задній повний привід Audi S6 e-tron сприяє динаміці водіння завдяки дуже змінному розподілу коліс. Audi S6 e-tron забезпечує системну потужність 370 кВт (405 кВт із системою запуску). S6 Sportback e-tron розганяється від 0 до 100 км/год за 3,9 секунди. Максимальна швидкість становить 240 км/год. Запас ходу понад 670 кілометрів.",
                        imageResId = 0
                    )
                )
                db.itemDao().insertItem(
                    ItemEntity(
                        title = "",
                        description = "",
                        imageResId = R.drawable.web_960_a6_e_tron
                    )
                )
                db.itemDao().insertItem(
                    ItemEntity(
                        title = "Q6 e-tron",
                        description = "",
                        imageResId = 0
                    )
                )
                db.itemDao().insertItem(
                    ItemEntity(
                        title = "",
                        description = "Audi Q6 e-tron 3 є першою серійною моделлю на електричній платформі Premium (PPE) і, отже, є новим еталоном для проектування за допомогою технологій. Нова модель не тільки характеризується вражаючою продуктивністю водіння та заряджання, але й встановлює стандарти щодо запасу ходу та ефективності.",
                        imageResId = 0
                    )
                )
                db.itemDao().insertItem(
                    ItemEntity(
                        title = "",
                        description = "",
                        imageResId = R.drawable.web_960_q6_e_tron
                    )
                )
            }

            // Завантажуємо дані для відображення в RecyclerView
            val items = db.itemDao().getAllItems()
            val listItems = items.map { entity ->
                when {
                    entity.description.isNotEmpty() -> ListItem.TextItem(entity.description)
                    entity.imageResId != 0 -> ListItem.PhotoItem(entity.imageResId)
                    else -> ListItem.TitleItem(entity.title)
                }
            }
            adapter.updateData(listItems)
        }

        // Кнопка очищення бази даних
        val clearDbButton: Button = findViewById(R.id.clearDbButton)
        clearDbButton.setOnClickListener {
            lifecycleScope.launch {
                db.itemDao().deleteAllItems() // Очищаємо таблицю
                Toast.makeText(this@MainActivity, "База даних очищена", Toast.LENGTH_SHORT).show()

                // Очищаємо список у RecyclerView
                adapter.updateData(emptyList())
            }
        }
    }
}
