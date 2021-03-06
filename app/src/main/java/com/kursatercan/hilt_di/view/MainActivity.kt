package com.kursatercan.hilt_di.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kursatercan.hilt_di.R
import com.kursatercan.hilt_di.databinding.ActivityMainBinding
import com.kursatercan.hilt_di.model.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var newsList = emptyList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.viewModelScope.launch(Dispatchers.IO) {
            newsList = viewModel.getNews().data!!.articles
            withContext(Dispatchers.Main) {
                delay(1000L)
                binding.text.text = newsList[0].content
            }
        }

        object: CountDownTimer(5000, 1) {
            override fun onTick(p0: Long) {
                println(p0.toString())
            }
            override fun onFinish() {
                println("Bitti")
            }
        }.start()

    }
}