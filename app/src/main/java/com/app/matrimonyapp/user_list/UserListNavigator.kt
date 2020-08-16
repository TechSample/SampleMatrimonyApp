package com.app.matrimonyapp.user_list

import com.app.matrimonyapp.base.BaseNavigator
import com.app.matrimonyapp.network.response.Results


interface UserListNavigator : BaseNavigator {

    fun goToUserDetails(user: Results)
}