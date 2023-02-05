package ru.tinkoff.domain.usecase

import ru.tinkoff.data.repository.FilmRepository
import ru.tinkoff.domain.mapFilmEntityToFilm
import ru.tinkoff.domain.models.Film
import javax.inject.Inject

class FilmUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {

    suspend fun getFilmList(): List<Film> {
        return filmRepository.getFilmList().map { mapFilmEntityToFilm(it) }
    }
}