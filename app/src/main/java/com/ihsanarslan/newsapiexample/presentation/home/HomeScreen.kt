package com.ihsanarslan.newsapiexample.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(){

    val viewModel = hiltViewModel<HomeScreenViewModel>()

    val allArticles = viewModel.allArticles.collectAsStateWithLifecycle()

    LazyColumn(
        content = {
            items(allArticles.value.size) {
                ArticleCard(allArticles.value[it])
            }
        }
    )





}