package com.app.matrimonyapp.user_list

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.matrimonyapp.R
import com.app.matrimonyapp.base.BaseFragment
import com.app.matrimonyapp.databinding.FragmentAcceptedMatchesBinding


class AcceptedMatchesFragment : BaseFragment<FragmentAcceptedMatchesBinding, UserListViewModel>() {

    override fun getLayoutId() = R.layout.fragment_accepted_matches
    override fun getViewModel() = UserListViewModel::class.java

    override fun onBinding() {
        mBinding.rvAcceptedMatches.layoutManager = LinearLayoutManager(activity)
        val userAdapter = UserListAdapter(activity as Context, mViewModel, false)
        mBinding.rvAcceptedMatches.adapter = userAdapter

        mViewModel.acceptedMembersList.observe(viewLifecycleOwner, Observer {
            println("acceptedMembersList it size"+it.size)
            userAdapter.updateList(it)
            mBinding.tvNoAcceptedMatches.visibility = if (it.size > 0) View.GONE else View.VISIBLE

        })
    }
}
