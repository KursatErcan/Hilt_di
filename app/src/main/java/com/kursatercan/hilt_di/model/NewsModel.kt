package com.kursatercan.hilt_di.model

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)