package com.kursatercan.hilt_di.client

import com.kursatercan.hilt_di.service.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module // hilt module olarak tanımlar
@InstallIn(SingletonComponent::class) // kapsamı belirler
object ClientModule {

    @Singleton
    @Provides
    fun provideNewsApi(): RetrofitService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/")
            .build()
            .create(RetrofitService::class.java)
    }
}