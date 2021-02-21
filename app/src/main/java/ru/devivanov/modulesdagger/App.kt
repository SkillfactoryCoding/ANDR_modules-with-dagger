package ru.devivanov.modulesdagger

import android.app.Application
import ru.devivanov.core_api.db.ItemsDao
import ru.devivanov.modulesdagger.di.FacadeComponent
import javax.inject.Inject

class App : Application() {
    //Инжектим доступ к БД
    @Inject
    lateinit var itemsDao: ItemsDao

    override fun onCreate() {
        super.onCreate()
        instance = this
        getFacade().inject(this)
    }

    private fun getFacade(): FacadeComponent {
        //Создаем компонент
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    companion object {
        //Ссылка для доступа к itemsDao из активити
        lateinit var instance: App
            private set
        private var facadeComponent: FacadeComponent? = null
    }
}