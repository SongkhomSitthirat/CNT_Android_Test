package com.sitthirat.cntandroidtest

import android.app.Application
import com.sitthirat.di.appModule
import com.sitthirat.di.useCaseModule
import com.sitthirat.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(appModule, useCaseModule, viewModelModule))
        }
    }
}