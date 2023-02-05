package ru.tinkoff.domain.models

data class Film(
    val id: Long,
    val title: String,
    val genre: String,
    val filmImage: String
)