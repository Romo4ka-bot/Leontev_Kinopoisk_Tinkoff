package ru.tinkoff.leontev_kinopoisk_tinkoff.models

data class FilmModel(
    val id: Long,
    val title: String,
    val genre: String,
    val filmImage: String
)