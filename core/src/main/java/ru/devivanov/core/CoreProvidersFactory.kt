package ru.devivanov.core

import ru.devivanov.core_api.AppProvider
import ru.devivanov.core_api.db.DatabaseProvider
import ru.devivanov.core_impl.DaggerDatabaseComponent

object CoreProvidersFactory {
    fun createDatabaseBuilder(appProvider: AppProvider): DatabaseProvider {
        return DaggerDatabaseComponent.builder().appProvider(appProvider).build()
    }
}