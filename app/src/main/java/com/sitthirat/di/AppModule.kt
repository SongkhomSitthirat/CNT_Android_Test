package com.sitthirat.di

import com.sitthirat.cntandroidtest.network.ApiService
import com.sitthirat.cntandroidtest.network.EndpointInterface
import com.sitthirat.cntandroidtest.repository.RemoteRepositoryImpl
import com.sitthirat.cntandroidtest.usecase.GetJsonDatasUseCase
import com.sitthirat.cntandroidtest.util.SharedPref
import com.sitthirat.cntandroidtest.view.MainActivityViewModel
import com.sitthirat.cntandroidtest.view.main.MainFragmentViewModel
import com.sitthirat.cntandroidtest.view.main.first.FirstFragmentViewModel
import com.sitthirat.cntandroidtest.view.main.forth.ForthFragmentViewModel
import com.sitthirat.cntandroidtest.view.main.second.SecondFragmentViewModel
import com.sitthirat.cntandroidtest.view.main.third.ThirdFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

val appModule = module {
    single { SharedPref(androidContext()) }
    single { ApiService() }
    single {
        val apiService: ApiService = get()
        RemoteRepositoryImpl(apiService.getEndpointInterface(EndpointInterface::class.java))
    }
}

val useCaseModule = module {
    factory { GetJsonDatasUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MainActivityViewModel() }
    viewModel { MainFragmentViewModel() }
    viewModel { FirstFragmentViewModel(get()) }
    viewModel { SecondFragmentViewModel() }
    viewModel { ThirdFragmentViewModel(get()) }
    viewModel { ForthFragmentViewModel() }
}