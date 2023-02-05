package ru.tinkoff.domain

import ru.tinkoff.data.models.FilmEntity
import ru.tinkoff.domain.models.Film

fun mapFilmEntityToFilm(filmEntity: FilmEntity): Film {
    return with(filmEntity) {
        Film(id, title, genre[0], filmImage)
    }
}