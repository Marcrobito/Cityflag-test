package com.jamadev.cityflagtest

import com.jamadev.cityflagtest.applications.model.AppsRepository
import com.jamadev.cityflagtest.applications.viewmodel.AppListContract
import com.jamadev.cityflagtest.applications.viewmodel.AppViewModel
import com.jamadev.cityflagtest.network.AppServiceApiClient
import org.koin.dsl.module


val appModule = module {
    factory { App() }
}

val networkModule = module {
    single { AppServiceApiClient().provideApiService() }
}

val appListModule = module {
    factory { AppsRepository() as AppListContract.Repository}
    factory { AppViewModel()  }
}