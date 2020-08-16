package com.app.matrimonyapp.network
import com.app.matrimonyapp.network.response.MemberListResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface APIInterface {

    @GET("api/?results=10")
    fun fetchUsers(): Single<MemberListResponse>
}