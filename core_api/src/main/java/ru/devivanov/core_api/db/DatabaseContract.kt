package ru.devivanov.core_api.db

interface DatabaseContract {
    fun itemsDao(): ItemsDao
}