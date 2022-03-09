package com.kursatercan.hilt_di.repository

import com.kursatercan.hilt_di.model.NewsModel
import com.kursatercan.hilt_di.util.Resource

interface NewsRepository {

    suspend fun getNewAllNews(): Resource<NewsModel>
}