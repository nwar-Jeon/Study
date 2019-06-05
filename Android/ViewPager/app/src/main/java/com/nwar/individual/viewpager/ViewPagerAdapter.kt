package com.nwar.individual.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapter(val items : ArrayList<Fragment>, fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = items.size

    override fun getItem(p0: Int): Fragment = items.get(p0)

    fun addItem(fragment : Fragment){
        items.add(fragment)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "페이지 " + position.toString()
    }
}