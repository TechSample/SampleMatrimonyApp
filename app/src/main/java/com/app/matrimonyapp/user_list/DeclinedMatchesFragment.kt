package com.app.matrimonyapp.user_list

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.matrimonyapp.R
import com.app.matrimonyapp.base.BaseFragment
import com.app.matrimonyapp.databinding.FragmentDeclinedMatchesBinding


class DeclinedMatchesFragment : BaseFragment<FragmentDeclinedMatchesBinding, UserListViewModel>() {

    override fun getLayoutId() = R.layout.fragment_declined_matches
    override fun getViewModel() = UserListViewModel::class.java

    override fun onBinding() {
        mBinding.rvDeclinedMatches.layoutManager = LinearLayoutManager(activity)
        val userAdapter = UserListAdapter(activity as Context, mViewModel, false)
        mBinding.rvDeclinedMatches.adapter = userAdapter

        mViewModel.declinedMembersList.observe(viewLifecycleOwner, Observer {
            println("declinedMembersList it size"+it.size)
            userAdapter.updateList(it)
            mBinding.tvNoDeclinedMatches.visibility = if (it.size > 0) View.GONE else View.VISIBLE

        })
    }
}
