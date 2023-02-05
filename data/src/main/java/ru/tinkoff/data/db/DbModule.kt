package ru.tinkoff.data.db

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.tinkoff.data.db.dao.FilmDao
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context): AppDataBase {
        return AppDataBase.getDataBase(context)
    }

    @Provides
    @Singleton
    fun provideFilmDao(dataBase: AppDataBase): FilmDao = dataBase.filmDao()
}