package com.app.matrimonyapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel<N : BaseNavigator> : ViewModel() {

    protected var mNavigator: N? = null
    protected val mDisposable = CompositeDisposable()
    protected val dialogMessage: MutableLiveData<String> = MutableLiveData("")
    protected val dialogVisibility: MutableLiveData<Boolean> = MutableLiveData(false)

    fun setNavigator(navigator: BaseNavigator) {
        mNavigator = navigator as N
    }

    fun getMessage() = dialogMessage
    fun getVisibility() = dialogVisibility

    protected fun checkError(throwable: Throwable) {
        dialogVisibility.value = false
        throwable.message?.apply {
            if (this.contains("500") || this.contains("Socket"))
                mNavigator!!.onError("No Internet Connection $this")
            else
                mNavigator!!.onError(this)
        }
    }

    override fun onCleared() {
        super.onCleared()
        mNavigator = null
        if (!mDisposable.isDisposed) {
            mDisposable.dispose()
        }
    }

}