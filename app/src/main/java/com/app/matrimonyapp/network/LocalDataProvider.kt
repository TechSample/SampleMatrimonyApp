package com.app.matrimonyapp.network

import com.app.matrimonyapp.network.response.Results
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

interface LocalDataProvider {

    fun insertMembersInDb(usersList: List<Results>): Completable

    fun getMembersFromDb(
        success: Consumer<ArrayList<Results>>,
        error: Consumer<Throwable>
    ): Disposable

    fun updateMember(
        user: Results,
        success: Consumer<Int>,
        error: Consumer<Throwable>
    ): Disposable

    fun getAcceptedMembers(
        success: Consumer<ArrayList<Results>>,
        error: Consumer<Throwable>
    ): Disposable

    fun getDeclinedMembers(
        success: Consumer<ArrayList<Results>>,
        error: Consumer<Throwable>
    ): Disposable
}