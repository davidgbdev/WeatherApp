package com.gonzalez.blanchard.interceptor

import com.gonzalez.blanchard.remotedatasource.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AccessTokenInterceptor @Inject constructor() : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val accessToken = getAccessToken()
        
        val originalHttpUrl = originalRequest.url
        val newHttpUrl: HttpUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("access_key", accessToken)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newHttpUrl)
            .build()

        return chain.proceed(newRequest)
    }
    
    private fun getAccessToken(): String = BuildConfig.WEATHERSTACK_ACCESS_KEY
}
