package com.app.matrimonyapp.network

import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

interface RemoteDataProvider {

    fun fetchMembersAndSave(
        success: Consumer<Boolean>,
        error: Consumer<Throwable>
    ): Disposable

}