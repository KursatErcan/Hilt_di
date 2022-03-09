package com.kursatercan.hilt_di.service

import com.kursatercan.hilt_di.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("top-headlines?country=tr&apiKey=9df663ddf6464d11a1d7601967f8f33f")
    suspend fun getNewsFromApi(): Response<NewsModel>
}