package com.ihsanarslan.newsapiexample.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ihsanarslan.newsapiexample.domain.model.Article
import com.ihsanarslan.newsapiexample.domain.usecase.GetEverythingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getEverythingUseCase: GetEverythingUseCase
) : ViewModel() {

    private val _allArticles = MutableStateFlow<List<Article>>(emptyList())
    val allArticles : StateFlow<List<Article>>
        get() = _allArticles.asStateFlow()

    init {
        getEverything()
    }

    fun getEverything() {
        viewModelScope.launch {
            getEverythingUseCase.invoke().collect {
                _allArticles.value = it.articles
            }
        }
    }


}