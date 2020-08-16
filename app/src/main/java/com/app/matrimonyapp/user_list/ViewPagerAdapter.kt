package com.app.matrimonyapp.user_list

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.matrimonyapp.R


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = listOf(UserListFragment(), AcceptedMatchesFragment(), DeclinedMatchesFragment())


    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}