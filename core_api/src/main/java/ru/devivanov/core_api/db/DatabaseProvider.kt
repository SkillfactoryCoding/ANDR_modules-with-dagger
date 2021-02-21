package ru.devivanov.core_api.db

interface DatabaseProvider {
    fun itemsDao(): ItemsDao
}