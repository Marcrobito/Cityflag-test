package com.jamadev.cityflagtest.applications.model

import android.util.Log
import com.jamadev.cityflagtest.applications.viewmodel.AppListContract
import com.jamadev.cityflagtest.network.AppServiceApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class AppsRepository:AppListContract.Repository, KoinComponent {
    private val apiServiceApi: AppServiceApi by inject()
    private var cachedApps = emptyList<AppDetail>()
    private lateinit var viewModel: AppListContract.ViewModel

    private var disposable:Disposable? = null

    override fun setViewModel(viewModel: AppListContract.ViewModel) {
        this.viewModel = viewModel
        getApps()
    }

    private fun getApps(){
        disposable = getAppsFromService()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::setAppList,this::handleError)
    }

    private fun getAppsFromService():Observable<List<AppDetail>>{
        return apiServiceApi.getAppList(20)
            .map{AppConverter().generateAppList(it.feed)  }
            .doOnNext { cachedApps =  it }

    }

    private fun setAppList(list: List<AppDetail>){
        viewModel.setListFragment(list)
        disposable!!.dispose()
    }

    private fun handleError(e: Throwable) {
        Log.e("Error", e.toString())
        disposable!!.dispose()
    }

}