package ru.tinkoff.leontev_kinopoisk_tinkoff.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.tinkoff.leontev_kinopoisk_tinkoff.popular.FilmListFragment

@Module
internal abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun provideFilmListFragment(): FilmListFragment
}