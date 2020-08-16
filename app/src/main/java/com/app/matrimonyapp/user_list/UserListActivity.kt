package com.app.matrimonyapp.user_list

import com.app.matrimonyapp.R
import com.app.matrimonyapp.base.BaseActivity
import com.app.matrimonyapp.base.BaseNavigator
import com.app.matrimonyapp.databinding.ActivityUserListBinding
import com.app.matrimonyapp.network.response.Results
import com.app.matrimonyapp.utils.showMessage
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_user_list.view.*

class UserListActivity : BaseActivity<ActivityUserListBinding, UserListViewModel>(), UserListNavigator {

    override fun getLayoutId() = R.layout.activity_user_list
    override fun getViewModel() = UserListViewModel::class.java
    override fun getNavigator(): BaseNavigator = this@UserListActivity
    override fun onInternetError() {}
    override fun onError(message: String) = showMessage(message)

    override fun onBinding() {
        supportActionBar?.run {
            title = resources.getString(R.string.user_list_title)
        }
        val tabs = listOf(this.getString(R.string.all_matches),this.getString(R.string.accepted_matches),this.getString(R.string.declined_matches))

        val adapter = ViewPagerAdapter(this)
        mBinding.viewPager.adapter = adapter

        TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
            tab.text = tabs[position]
            mBinding.viewPager.setCurrentItem(tab.position, true)
        }.attach()

    }



    override fun goToUserDetails(user: Results) {

    }

}

