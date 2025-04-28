package com.ihsanarslan.newsapiexample.presentation.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(){

    val viewModel = hiltViewModel<HomeScreenViewModel>()

    val allArticles = viewModel.allArticles.collectAsStateWithLifecycle()

    val category = remember { mutableStateOf("health") }

    LazyColumn{
        item {
            Row {
                TextField(
                    value = category.value,
                    onValueChange = {
                        category.value = it
                    }
                )
                Button(
                    onClick = {
                        viewModel.topHeadlines(category.value)
                    }
                ) {
                    Text("Getir")
                }
            }

        }
        items(allArticles.value.size) {
            ArticleCard(allArticles.value[it])
        }
    }





}