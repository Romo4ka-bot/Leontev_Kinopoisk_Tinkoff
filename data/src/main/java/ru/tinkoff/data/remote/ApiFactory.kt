package ru.tinkoff.data.remote

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.tinkoff.data.BuildConfig
import java.util.concurrent.TimeUnit


object ApiFactory {

//    private val gson = GsonBuilder()
//        .setLenient()
//        .create()

    private val apiKeyInterceptor = Interceptor { chain ->
        val original = chain.request()
        original.url.newBuilder().addQueryParameter(
            "X-API-KEY", BuildConfig.API_KEY
        ).build().let {
            chain.proceed(original.newBuilder().url(it).build())
        }
    }

    private val headerInterceptor = Interceptor { chain ->
        val original = chain.request()
        original.url.newBuilder().addQueryParameter(
            "content-type", "application/json"
        ).build().let {
            chain.proceed(original.newBuilder().url(it).build())
        }
    }

    private val client by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(LoggingInterceptor())
//            .addInterceptor(headerInterceptor)
//            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.API_ENDPOINT)
            .build()
    }

//    val filmApi by lazy {
//        retrofit.create(
//            FilmApi::class.java
//        )
//    }
}