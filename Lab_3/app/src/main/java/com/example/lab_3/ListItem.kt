package com.example.lab_3

sealed class ListItem {
    data class TitleItem(val title: String) : ListItem()
    data class TextItem(val text: String) : ListItem()
    data class PhotoItem(val imageUrl: String) : ListItem()
}
