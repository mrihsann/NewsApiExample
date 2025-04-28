package com.ihsanarslan.newsapiexample.domain.usecase

import com.ihsanarslan.newsapiexample.data.repository.NewsApiRepositoryImpl
import com.ihsanarslan.newsapiexample.domain.model.Root
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopHeadlinesUseCase @Inject constructor(
    private val newsApiRepositoryImpl: NewsApiRepositoryImpl
) {
    operator fun invoke(category: String): Flow<Root> {
        return newsApiRepositoryImpl.topHeadlines(category)
    }

}