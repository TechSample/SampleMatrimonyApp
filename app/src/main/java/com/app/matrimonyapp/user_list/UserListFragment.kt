package com.app.matrimonyapp.user_list


import android.content.Context
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.matrimonyapp.R
import com.app.matrimonyapp.base.BaseFragment
import com.app.matrimonyapp.databinding.FragmentUserListBinding

class UserListFragment : BaseFragment<FragmentUserListBinding, UserListViewModel>() {

    override fun getLayoutId() = R.layout.fragment_user_list
    override fun getViewModel() = UserListViewModel::class.java

    override fun onBinding() {
        mBinding.rvUsers.layoutManager = LinearLayoutManager(activity)
        val userAdapter = UserListAdapter(activity as Context, mViewModel, true)
        mBinding.rvUsers.adapter = userAdapter

        mViewModel.userList.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                userAdapter.updateList(it)
            }else{
                mViewModel.fetchUsersAndSaveInDB()
            }
        })


      mViewModel.getMembersFromDB()
      mViewModel.getAcceptedMembers()
      mViewModel.getDeclinedMembers()


    }

}
