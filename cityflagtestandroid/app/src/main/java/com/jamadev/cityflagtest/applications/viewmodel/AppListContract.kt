package com.jamadev.cityflagtest.applications.viewmodel

import com.jamadev.cityflagtest.applications.model.AppDetail

interface AppListContract {
    interface Repository {
        fun setViewModel(viewModel: ViewModel)
    }
    interface ViewModel{
        fun setListFragment(appList:List<AppDetail>)
    }
}