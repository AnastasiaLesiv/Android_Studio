package com.example.lab_3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_3.data.ListItemDao
import com.example.lab_3.data.ListItemEntity
import kotlinx.coroutines.launch

class ListItemViewModel(private val dao: ListItemDao) : ViewModel() {

    //val items = dao.getAllItems()

    fun insertItem(item: ListItemEntity) {
        viewModelScope.launch {
            dao.insertItem(item)
        }
    }

    fun deleteItem(item: ListItemEntity) {
        viewModelScope.launch {
            dao.deleteItem(item)
        }
    }
}
