package com.akshay.compose_catchflicks.di.module


import com.akshay.compose_catchflicks.BuildConfig
import com.akshay.compose_catchflicks.data.remote.Networking
import com.akshay.compose_catchflicks.repository.PopularRepository
import com.akshay.compose_catchflicks.ui.popular.PopularViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/

val appModule = module {

    single {
        Networking.provideOkhttpClientInstance(
            context = androidApplication(),
            cacheSize = 10 * 1024 * 1024
        )
    }

    single {
        Networking.provideRetrofitInstance(
            apiKey =  BuildConfig.TMDB_API_KEY,
            baseUrl = BuildConfig.BASE_URL,
            okHttpClient = get(),
            gsonConverter = get()
        )
    }

    single { GsonConverterFactory.create() }

    single { PopularRepository(get()) }

    viewModel { PopularViewModel(get()) }
}
