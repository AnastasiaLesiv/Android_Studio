// MainViewModel.kt
package com.example.lab_1.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.lab_1.R

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val text = MutableLiveData<String>().apply {
        value = application.getString(R.string.textview)    }

    fun changeText() {
           text.value = getApplication<Application>().getString(R.string.custom_text)
    }
}
