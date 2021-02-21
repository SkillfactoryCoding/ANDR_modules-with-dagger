package ru.devivanov.core_api.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "ITEMS")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String
)