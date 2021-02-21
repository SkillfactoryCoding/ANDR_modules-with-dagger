package ru.devivanov.core_impl

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ru.devivanov.core_api.db.DatabaseContract
import ru.devivanov.core_api.db.ItemsDao
import javax.inject.Singleton

private const val DATABASE_NAME = "ITEMS_DB"

@Module
class DatabaseModule {
    @Provides
    @Reusable
    fun provideItemsDao(databaseContract: DatabaseContract): ItemsDao {
        return databaseContract.itemsDao()
    }

    @Provides
    @Singleton
    fun provideItemsDatabase(context: Context): DatabaseContract {
        return Room.databaseBuilder(
            context,
            ItemsDatabase::class.java, DATABASE_NAME
        ).build()
    }
}