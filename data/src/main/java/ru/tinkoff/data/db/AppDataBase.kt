package ru.tinkoff.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.tinkoff.data.db.dao.FilmDao
import ru.tinkoff.data.db.models.FilmLocal

@Database(version = 1, entities = [FilmLocal::class], exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "kinopoisk_db"
        private var instance: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration().build()
                instance!!
            }
        }
    }

    abstract fun filmDao(): FilmDao
}