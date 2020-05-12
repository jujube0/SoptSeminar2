package com.example.soptseminar2.webToon


import Webt_Tue
import Webt_wednes
import android.annotation.SuppressLint
import android.app.LocalActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.soptseminar2.R
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.fragment_webt_wednes.*

/**
 * A simple [Fragment] subclass.
 */
class Library : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewpager_library.adapter=PagerAdapter(childFragmentManager)
        tabs.setupWithViewPager(viewpager_library)

    }




}
@SuppressLint("WrongConstant")
//viewpager와 연결
private class PagerAdapter(fm: FragmentManager):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Webt_Mon()
            1 -> Webt_Tue()
            else -> Webt_wednes()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "monday"
            1->return "tuesday"
            else-> return "wednesday"
        }
    }
}