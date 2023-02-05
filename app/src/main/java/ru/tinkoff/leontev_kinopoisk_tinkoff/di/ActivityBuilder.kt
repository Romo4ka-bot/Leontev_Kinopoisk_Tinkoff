package ru.tinkoff.leontev_kinopoisk_tinkoff.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.tinkoff.leontev_kinopoisk_tinkoff.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    internal abstract fun provideActivityBuilder(): MainActivity
}