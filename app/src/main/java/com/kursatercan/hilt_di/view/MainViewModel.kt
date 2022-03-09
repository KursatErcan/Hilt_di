package com.kursatercan.hilt_di.view

import androidx.lifecycle.ViewModel
import com.kursatercan.hilt_di.model.NewsModel
import com.kursatercan.hilt_di.repository.MainNewsRepository
import com.kursatercan.hilt_di.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepository: MainNewsRepository): ViewModel() {

    suspend fun getNews(): Resource<NewsModel> = newsRepository.getNewAllNews()

}