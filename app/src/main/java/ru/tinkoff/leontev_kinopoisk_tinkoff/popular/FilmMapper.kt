package ru.tinkoff.leontev_kinopoisk_tinkoff.popular

import ru.tinkoff.domain.models.Film
import ru.tinkoff.leontev_kinopoisk_tinkoff.models.FilmModel

fun mapFilmToFilmModel(film: Film): FilmModel {
    return with(film) {
        FilmModel(id, title, genre, filmImage)
    }
}