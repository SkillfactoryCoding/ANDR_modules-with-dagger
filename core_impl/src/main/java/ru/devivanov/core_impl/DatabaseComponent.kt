package ru.devivanov.core_impl

import dagger.Component
import ru.devivanov.core_api.AppProvider
import ru.devivanov.core_api.db.DatabaseProvider
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent : DatabaseProvider