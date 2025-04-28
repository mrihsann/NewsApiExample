package com.ihsanarslan.newsapiexample.data.remote

import com.ihsanarslan.newsapiexample.domain.model.Root
import com.ihsanarslan.newsapiexample.utils.Constants
import com.ihsanarslan.newsapiexample.utils.Constants.API_KEY
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String = Constants.QUERY,
        @Query("apiKey") apiKey: String = API_KEY,
    ) : Root

    @GET("v2/top-headlines")
    suspend fun topHeadlines(
        @Query("country") country: String = "us",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = API_KEY,
    ) : Root

}