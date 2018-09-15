package com.example.tilman.samba_demo.mvp.home.calendar.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarAttending
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarHosting
import javax.inject.Inject

class CalendarViewPagerAdapter @Inject constructor(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){


    override fun getItem(position: Int): Fragment {

        return when(position){

            0 -> HomeFragmentCalendarAttending.newInstance()

            1 -> HomeFragmentCalendarHosting.newInstance()

            else -> HomeFragmentCalendarAttending.newInstance()


        }

    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position){

            0 -> "ATTENDING"

            1 -> "HOSTING"

            else -> "NULL"


        }

    }

    override fun getCount(): Int {

        return 2

    }


}