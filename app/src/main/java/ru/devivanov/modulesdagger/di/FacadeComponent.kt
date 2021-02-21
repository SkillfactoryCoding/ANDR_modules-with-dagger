package ru.devivanov.modulesdagger.di

import android.app.Application
import dagger.Component
import ru.devivanov.core.CoreProvidersFactory
import ru.devivanov.core_api.AppProvider
import ru.devivanov.core_api.db.DatabaseProvider
import ru.devivanov.modulesdagger.App

@Component(
    dependencies = [AppProvider::class, DatabaseProvider::class]
)
interface FacadeComponent {

    companion object {
        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .databaseProvider(CoreProvidersFactory.createDatabaseBuilder(AppComponent.create(application)))
                .build()
    }

    fun inject(app: App)
}