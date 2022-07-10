package com.akshay.compose_catchflicks.data.remote

import android.content.Context
import com.akshay.compose_catchflicks.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
object Networking {

    private const val NETWORK_CALL_TIMEOUT = 60
    internal lateinit var API_KEY: String

    fun provideRetrofitInstance(
        apiKey: String,
        baseUrl: String,
        okHttpClient: OkHttpClient
    ): NetworkService {
        API_KEY = apiKey
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
            .create(NetworkService::class.java)
    }

    fun provideOkhttpClientInstance(
        context: Context,
        cacheSize: Long
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(Cache(context.cacheDir, cacheSize))
            .addInterceptor(
                HttpLoggingInterceptor()
                .apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                })
            .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
    }
}