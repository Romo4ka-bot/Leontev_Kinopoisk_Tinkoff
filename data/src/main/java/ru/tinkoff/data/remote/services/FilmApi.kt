package ru.tinkoff.data.remote.services

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ru.tinkoff.data.models.FilmDto
import ru.tinkoff.data.models.FilmEntity

interface FilmApi {

    @GET("/v2.2/films/top")
    suspend fun getFilmList(
        @Header("X-API-KEY") apiKey: String,
        @Header("Content-Type") contentType: String,
        @Query("type") type: String,
        @Query("page") page: Int
    ): Response<FilmDto>
}
