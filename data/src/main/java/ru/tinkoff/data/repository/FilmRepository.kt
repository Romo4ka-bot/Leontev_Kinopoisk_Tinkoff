package ru.tinkoff.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.tinkoff.data.BuildConfig
import ru.tinkoff.data.db.dao.FilmDao
import ru.tinkoff.data.models.FilmEntity
import ru.tinkoff.data.remote.services.FilmApi
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val filmApi: FilmApi,
    private val filmDao: FilmDao
) {

    suspend fun getFilmList(): List<FilmEntity> {
        return getLocalList()
//        filmApi.getFilmList(
//            BuildConfig.API_KEY,
//            "application/json",
//            "TOP_100_POPULAR_FILMS",
//            1
//        ).body()?.films ?: listOf()
    }

    private fun getLocalList(): List<FilmEntity> {
        return listOf(
            FilmEntity(
                4370148,
                "Чебурашка",
                listOf("комедия", "семейный"),
                "https://kinopoiskapiunofficial.tech/images/posters/kp/4370148.jpg"
            ),
            FilmEntity(
                840821,
                "Кот в сапогах 2: Последнее желание",
                listOf("приключения", "фэнтези", "комедия", "мультфильм"),
                "https://kinopoiskapiunofficial.tech/images/posters/kp/840821.jpg"
            ),
            FilmEntity(
                505898,
                "Аватар: Путь воды",
                listOf("фантастика", "приключения", "боевик", "фэнтези"),
                "https://kinopoiskapiunofficial.tech/images/posters/kp/505898.jpg"
            ),
            FilmEntity(
                5045951,
                "О чем говорят мужчины. Простые удовольствия",
                listOf("комедия"),
                "https://kinopoiskapiunofficial.tech/images/posters/kp/5045951.jpg"
            )
        )
    }

    fun getFilm(): FilmEntity {
        return FilmEntity(
            4370148,
            "Чебурашка",
            listOf("комедия", "семейный"),
            "https://kinopoiskapiunofficial.tech/images/posters/kp/4370148.jpg"
        )
    }
}