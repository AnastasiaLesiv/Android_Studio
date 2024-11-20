package com.example.lab_1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.lab_1.view_model.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Підключаємо XML-макет

        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)

        // Спостерігаємо за зміною тексту у ViewModel
        viewModel.text.observe(this, Observer { newText ->
            textView.text = newText  // Оновлюємо текст у TextView
        })

        // Додаємо обробник натискання для кнопки
        button.setOnClickListener {
            viewModel.changeText() // Змінюємо текст через ViewModel
        }
    }
}
