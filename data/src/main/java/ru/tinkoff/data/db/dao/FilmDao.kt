package ru.tinkoff.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.tinkoff.data.db.models.FilmLocal

@Dao
interface FilmDao {

    @Delete
    suspend fun delete(filmLocal: FilmLocal)

    @Insert
    suspend fun insert(filmLocal: FilmLocal)

    @Query("SELECT * FROM film_table WHERE id = :idFilm")
    suspend fun getFilmById(idFilm: String): FilmLocal
}