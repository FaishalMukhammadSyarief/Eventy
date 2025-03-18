package com.zhalz.eventy.di

import com.crocodic.core.helper.NetworkHelper
import com.zhalz.eventy.data.remote.ApiService
import com.zhalz.eventy.data.remote.interceptor.JsonInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {

        val client = NetworkHelper.provideOkHttpClient()
            .newBuilder()
            .addInterceptor(JsonInterceptor())
            .build()

        val apiService: ApiService = NetworkHelper.provideApiService(
            "http://project.crocodic.academy/api/v1/",
            okHttpClient = client,
            converterFactory = listOf(GsonConverterFactory.create())
        )

        return apiService
    }

}