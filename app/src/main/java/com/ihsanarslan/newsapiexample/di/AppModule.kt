package com.ihsanarslan.newsapiexample.di

import com.ihsanarslan.newsapiexample.data.remote.NewsApi
import com.ihsanarslan.newsapiexample.data.repository.NewsApiRepositoryImpl
import com.ihsanarslan.newsapiexample.domain.usecase.GetEverythingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit) : NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsApiRepository(newsApi: NewsApi) : NewsApiRepositoryImpl {
        return NewsApiRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideGetEverythingUseCase(newsApiRepositoryImpl: NewsApiRepositoryImpl) : GetEverythingUseCase {
        return GetEverythingUseCase(newsApiRepositoryImpl)
    }


}