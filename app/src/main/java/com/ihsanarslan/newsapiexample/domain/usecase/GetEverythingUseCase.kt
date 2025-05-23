package com.ihsanarslan.newsapiexample.domain.usecase

import com.ihsanarslan.newsapiexample.data.repository.NewsApiRepositoryImpl
import com.ihsanarslan.newsapiexample.domain.model.Root
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetEverythingUseCase @Inject constructor(
    private val newsApiRepositoryImpl: NewsApiRepositoryImpl
) {
    operator fun invoke(query: String) : Flow<Root> = flow {
        newsApiRepositoryImpl.getEverything(query = query).collect {
            emit(it)
        }
    }

}