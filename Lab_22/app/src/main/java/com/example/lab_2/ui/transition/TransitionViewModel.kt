package com.example.lab_2.ui.transition

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransitionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is transition Fragment"
    }
    val text: LiveData<String> = _text
}