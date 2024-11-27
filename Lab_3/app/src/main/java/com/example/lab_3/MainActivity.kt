package com.example.lab_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.ui.theme.Lab_3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Використовуємо XML макет

        val items = listOf(
            ListItem.TitleItem("A6 e-tron"),
            ListItem.TextItem("Задній повний привід Audi S6 e-tron сприяє динаміці водіння завдяки дуже змінному розподілу коліс. Audi S6 e-tron забезпечує системну потужність 370 кВт (405 кВт із системою запуску). S6 Sportback e-tron розганяється від 0 до 100 км/год за 3,9 секунди. Максимальна швидкість становить 240 км/год. Запас ходу понад 670 кілометрів.\n"),
            ListItem.PhotoItem(R.drawable.web_960_a6_e_tron),
            ListItem.TitleItem("Q6 e-tron"),
            ListItem.TextItem("Audi Q6 e-tron 3 є першою серійною моделлю на електричній платформі Premium (PPE) і, отже, є новим еталоном для проектування за допомогою технологій. Нова модель не тільки характеризується вражаючою продуктивністю водіння та заряджання, але й встановлює стандарти щодо запасу ходу та ефективності."),
            ListItem.PhotoItem(R.drawable.web_960_q6_e_tron)
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(items)
        recyclerView.adapter?.notifyDataSetChanged()
        recyclerView.addItemDecoration(decoration)
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()



    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_3Theme {
        Greeting("Android")
    }
}