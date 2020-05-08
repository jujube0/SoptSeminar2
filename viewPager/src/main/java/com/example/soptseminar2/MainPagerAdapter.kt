package com.example.soptseminar2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.soptseminar2.webToon.Library


class MainPagerAdapter(fm: FragmentManager):
FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Home()
            1 -> Library()
            else -> MyPage()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}