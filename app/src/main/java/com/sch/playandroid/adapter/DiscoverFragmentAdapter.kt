package com.sch.playandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sch.playandroid.entity.TabTypeBean

/**
 * Created by Sch.
 * Date: 2020/4/21
 * description: 发现页面 子fragment Adapter
 */
class DiscoverFragmentAdapter(
    private var fragments: List<Fragment>,
    fm: FragmentManager
) :
    FragmentStatePagerAdapter(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    val titles = arrayOf("广场", "体系", "导航")

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    fun updata(fragments: List<Fragment>) {
        this.fragments = fragments
        notifyDataSetChanged()
    }
}