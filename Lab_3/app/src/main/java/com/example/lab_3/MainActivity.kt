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
            ListItem.TitleItem("Заголовок 1"),
            ListItem.TextItem("Це приклад тексту 1"),
            ListItem.PhotoItem(R.drawable.ic_launcher_foreground),
            ListItem.TitleItem("Заголовок 2"),
            ListItem.TextItem("Це приклад тексту 2"),
            ListItem.PhotoItem(R.drawable.ic_launcher_foreground)
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