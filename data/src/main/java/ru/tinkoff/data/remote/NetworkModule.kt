package ru.tinkoff.data.remote

import dagger.Module
import dagger.Provides
import ru.tinkoff.data.remote.services.FilmApi
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideFilmApi(): FilmApi {
        return ApiFactory.retrofit.create(
            FilmApi::class.java
        )
    }
}