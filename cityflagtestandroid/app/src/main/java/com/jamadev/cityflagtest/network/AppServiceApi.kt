package com.jamadev.cityflagtest.network

import com.jamadev.cityflagtest.applications.model.FeedDTO
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AppServiceApi {
    @GET ("/us/rss/topfreeapplications/limit={limit}/json")
    fun getAppList(@Path("limit") limit:Int): Observable<FeedDTO>
}