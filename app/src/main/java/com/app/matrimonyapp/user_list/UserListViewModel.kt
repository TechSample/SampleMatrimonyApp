package com.app.matrimonyapp.user_list

import androidx.lifecycle.MutableLiveData
import com.app.matrimonyapp.base.BaseViewModel
import com.app.matrimonyapp.network.DataProvider
import com.app.matrimonyapp.network.response.Results
import io.reactivex.functions.Consumer


class UserListViewModel : BaseViewModel<UserListNavigator>() {

    val userList = MutableLiveData<ArrayList<Results>>()
    val acceptedMembersList = MutableLiveData<ArrayList<Results>>()
    val declinedMembersList = MutableLiveData<ArrayList<Results>>()


    fun fetchUsersAndSaveInDB() {
        dialogMessage.value = "Fetching Data..."
        dialogVisibility.value = true
        mDisposable.add(DataProvider.fetchMembersAndSave(Consumer {
            getMembersFromDB()
        }, Consumer { checkError(it) }))
    }

     fun getMembersFromDB() {
        mDisposable.add(DataProvider.getMembersFromDb(Consumer {
            dialogVisibility.value = false
            userList.value = it
        }, Consumer { checkError(it) }))
    }

    fun changeMemberAcceptStatus(userItem: Results) {
        dialogMessage.value = "Accepting..."
        dialogVisibility.value = true
        mDisposable.add(DataProvider.updateMember(userItem, Consumer {
            dialogVisibility.value = false
            if (it > -1) {
                getAcceptedMembers()
            }
        }, Consumer { checkError(it) }))
    }

    fun changeMemberDeclineStatus(userItem: Results) {
        dialogMessage.value = "Declining..."
        dialogVisibility.value = true
        mDisposable.add(DataProvider.updateMember(userItem, Consumer {
            dialogVisibility.value = false
            if (it > -1) {
                getDeclinedMembers()
            }
        }, Consumer { checkError(it) }))
    }

    fun getAcceptedMembers() {
        dialogMessage.value = "Processing.."
        dialogVisibility.value = true
        mDisposable.add(DataProvider.getAcceptedMembers(Consumer {
            dialogVisibility.value = false
            acceptedMembersList.value = it
            println("Accepted list size"+acceptedMembersList.value!!.size)
        }, Consumer { checkError(it) }))
    }

    fun getDeclinedMembers() {
        dialogMessage.value = "Processing.."
        dialogVisibility.value = true
        mDisposable.add(DataProvider.getDeclinedMembers(Consumer {
            dialogVisibility.value = false
            declinedMembersList.value = it
            println("Declined list size"+declinedMembersList.value!!.size)
        }, Consumer { checkError(it) }))
    }

}