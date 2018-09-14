package com.example.tilman.samba_demo.mvp.home.profile

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ProfileViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){


    override fun getItem(position: Int): Fragment {

        return when(position){

            0 -> HomeFragmentProfileAccount.newInstance()

            1 -> HomeFragmentProfileHistory.newInstance()

            2 -> HomeFragmentProfileSettings.newInstance()

            else -> HomeFragmentProfileAccount.newInstance()


        }

    }

    override fun getCount(): Int {


        return 3

    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position){

            0 -> "ACCOUNT"

            1 -> "HISTORY"

            2 -> "SETTINGS"

            else -> "Null"

        }


    }


}