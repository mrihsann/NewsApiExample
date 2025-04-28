package com.ihsanarslan.newsapiexample.data.remote

import com.ihsanarslan.newsapiexample.domain.model.Root
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/everything")
    fun getEvrything(
        @Query("q") query: String = "bitcoin",
        @Query("apiKey") apiKey: String = "848e8d93e283410f80e8fa5fab227884",
    ) : Flow<Root>

}