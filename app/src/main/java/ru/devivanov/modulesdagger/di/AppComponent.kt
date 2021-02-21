package ru.devivanov.modulesdagger.di

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.BindsInstance
import ru.devivanov.core_api.AppProvider
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent : AppProvider {
    companion object {
        private var appComponent: AppProvider? = null
        fun create(application: Application): AppProvider {
            return appComponent ?: DaggerAppComponent
                .builder()
                .application(application.applicationContext)
                .build().also {
                    appComponent = it
                }
        }
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun build(): AppComponent
    }
}