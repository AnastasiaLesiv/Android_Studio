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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.ui.theme.Lab_3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        val itemList = listOf(
            Item("Заголовок 1", "Опис 1"),
            Item("Заголовок 2", "Опис 2"),
            Item("Заголовок 3", "Опис 3"),
            Item("Заголовок 4", "Опис 4"),
            Item("Заголовок 5", "Опис 5"),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Налаштовуємо LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Зараз адаптер відсутній, додамо його пізніше
        recyclerView.adapter = Adapter(itemList)
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