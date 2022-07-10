package com.akshay.compose_catchflicks

import android.app.Application
import com.akshay.compose_catchflicks.di.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
class ComposeCatchflicksApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ComposeCatchflicksApplication)
            modules(listOf(appModule))
        }
    }
}
