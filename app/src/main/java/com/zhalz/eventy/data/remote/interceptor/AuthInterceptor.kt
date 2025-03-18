package com.zhalz.eventy.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(/*private val dataStoreUser: DataStoreUser*/): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = /*runBlocking { dataStoreUser.getUserSession().first().first }*/ ""

        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(request)
    }

}