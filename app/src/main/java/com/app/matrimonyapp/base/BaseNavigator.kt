package com.app.matrimonyapp.base

interface BaseNavigator {

    fun onInternetError();

    fun onError(message: String)
}