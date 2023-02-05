package ru.tinkoff.data.models

import com.google.gson.annotations.SerializedName

data class FilmEntity(
    @SerializedName("filmId")
    val id: Long,
    @SerializedName("nameRu")
    val title: String,
    @SerializedName("genres")
    val genre: List<String>,
    @SerializedName("posterUrlPreview")
    val filmImage: String
)