package com.app.matrimonyapp.network

import com.app.matrimonyapp.base.MatrimonyApplication
import com.app.matrimonyapp.db.UserDatabase
import com.app.matrimonyapp.network.response.Results
import com.app.matrimonyapp.utils.isNetworkAvailable
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

object DataProvider : RemoteDataProvider, LocalDataProvider {

    private val mServices by lazy { APIClient.getClient().create(APIInterface::class.java) }
    private val memberDao by lazy { UserDatabase.getDB(MatrimonyApplication.instance)!!.memberDao() }

    private fun noInternetAvailable(error: Consumer<Throwable>) =
        error.accept(Throwable("No Internet Connection"))

    private fun getDefaultDisposable(): Disposable = object : Disposable {
        override fun isDisposed() = false
        override fun dispose() {}
    }

    override fun fetchMembersAndSave(success: Consumer<Boolean>, error: Consumer<Throwable>): Disposable {
        if (isNetworkAvailable()) {
            return mServices.fetchUsers()
                .flatMapCompletable {
                    if (it.results.isNotEmpty())

                        return@flatMapCompletable insertMembersInDb(it.results)
                    else
                        return@flatMapCompletable Completable.error(Throwable("No Data Available"))
                }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ success.accept(true) }, {
                    error.accept(it)
                    println(it.message)
                })
        } else {
            noInternetAvailable(error)
            return getDefaultDisposable()
        }
    }

    override fun insertMembersInDb(usersList: List<Results>) = memberDao.insertMemberList(usersList)

    override fun getMembersFromDb(
        success: Consumer<ArrayList<Results>>,
        error: Consumer<Throwable>
    ): Disposable {
        return memberDao.getMemberList()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                success.accept(it as ArrayList<Results>)
            }, error)
    }


    override fun updateMember(
        user: Results, success: Consumer<Int>,
        error: Consumer<Throwable>
    ): Disposable {
        return memberDao.updateMember(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { success.accept(it) }, error)
    }

    override fun getAcceptedMembers(
        success: Consumer<ArrayList<Results>>,
        error: Consumer<Throwable>
    ): Disposable {
        return memberDao.getAcceptedMembers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { success.accept(it as ArrayList<Results>) }, error)
    }

    override fun getDeclinedMembers(
        success: Consumer<ArrayList<Results>>,
        error: Consumer<Throwable>
    ): Disposable {
        return memberDao.getDeclinedMembers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { success.accept(it as ArrayList<Results>) }, error)
    }
}