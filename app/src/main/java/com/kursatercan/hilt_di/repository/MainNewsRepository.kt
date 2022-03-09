package com.kursatercan.hilt_di.repository

import com.kursatercan.hilt_di.model.NewsModel
import com.kursatercan.hilt_di.service.RetrofitService
import com.kursatercan.hilt_di.util.Resource
import javax.inject.Inject

class MainNewsRepository @Inject constructor(
    private val retrofitService: RetrofitService
): NewsRepository {
    override suspend fun getNewAllNews(): Resource<NewsModel> {
        return try {
            val response = retrofitService.getNewsFromApi()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occurred", null)
            }else {
                Resource.error("An unknown error occurred", null)
            }
        } catch (e: Exception) {
            Resource.error("Check your internet connection!", null)
        }
    }
}