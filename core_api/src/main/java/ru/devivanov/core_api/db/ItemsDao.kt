package ru.devivanov.core_api.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.devivanov.core_api.dto.Item

@Dao
interface ItemsDao {
    @Query("SELECT * FROM ITEMS")
    fun getItems(): LiveData<List<Item>>

    @Insert
    fun insertItem(item: Item)
}