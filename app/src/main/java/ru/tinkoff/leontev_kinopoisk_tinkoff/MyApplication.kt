package ru.tinkoff.leontev_kinopoisk_tinkoff

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.tinkoff.leontev_kinopoisk_tinkoff.di.DaggerAppComponent

class MyApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<MyApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}