package com.jamadev.cityflagtest.applications.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamadev.cityflagtest.applications.model.AppDetail
import com.jamadev.cityflagtest.applications.view.AppDetailFragment
import com.jamadev.cityflagtest.applications.view.AppListFragment
import com.jamadev.cityflagtest.base.BaseFragment
import org.koin.core.KoinComponent
import org.koin.core.inject

class AppViewModel: ViewModel(), KoinComponent, AppListContract.ViewModel {

    private val repository:AppListContract.Repository by inject()

    private val fragment: MutableLiveData<BaseFragment> = MutableLiveData()

    private val appList = mutableListOf<AppDetail>()

    private val appListFragment = AppListFragment()
    private val appDetailFragment = AppDetailFragment()

    private var isListSelected = true

    init {
        repository.setViewModel(this)
    }

    fun getFragment(): MutableLiveData<BaseFragment> {
        return fragment
    }

    override fun setListFragment(appList:List<AppDetail>){
        this.appList.addAll(appList)
        appListFragment.setData(appList)
        fragment.value = appListFragment
        isListSelected = true
    }

    fun appSelected(position: Int) {
        appDetailFragment.setAppData(appList[position])
        fragment.value = appDetailFragment
        isListSelected = false
    }

    fun backPressed(){
        if (!isListSelected) {
            fragment.value = appListFragment
        }
    }
}