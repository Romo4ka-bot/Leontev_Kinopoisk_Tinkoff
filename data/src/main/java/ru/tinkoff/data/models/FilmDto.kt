package ru.tinkoff.data.models

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("pagesCount")
    val pagesCount: Int,
    @SerializedName("films")
    val films: List<FilmEntity>
)