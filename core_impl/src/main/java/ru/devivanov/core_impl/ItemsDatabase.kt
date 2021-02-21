package ru.devivanov.core_impl

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.devivanov.core_api.db.DatabaseContract
import ru.devivanov.core_api.dto.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemsDatabase : RoomDatabase(), DatabaseContract