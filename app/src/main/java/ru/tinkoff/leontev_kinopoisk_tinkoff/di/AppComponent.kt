package ru.tinkoff.leontev_kinopoisk_tinkoff.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.tinkoff.data.db.DbModule
import ru.tinkoff.data.remote.NetworkModule
import ru.tinkoff.leontev_kinopoisk_tinkoff.MyApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DbModule::class,
        NetworkModule::class,
        ViewModelBinder::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }
}