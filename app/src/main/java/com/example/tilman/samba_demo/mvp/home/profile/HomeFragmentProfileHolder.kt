package com.example.tilman.samba_demo.mvp.home.profile

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home_calendar.*
import kotlinx.android.synthetic.main.fragment_home_profile.*
import javax.inject.Inject

class HomeFragmentProfileHolder : BaseFragment() {


    @Inject
    lateinit var viewPagerAdapter: ProfileViewPagerAdapter


    val app = Samba.getApplication()


    companion object {

        fun newInstance(): HomeFragmentProfileHolder {

            val fragment = HomeFragmentProfileHolder()

            //Add arguments as necessary

            return fragment

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        app.createNavigationFragmentComponent(this)

        app.navigationFragmentComponent?.inject(this)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        //TabLayout

        profile_toolbar_tablayout.setTabTextColors(ContextCompat.getColor(context!!, R.color.tab_layout_not_selected), ContextCompat.getColor(context!!, R.color.white))
        profile_toolbar_tablayout.setupWithViewPager(profile_viewpager)


        //ViewPager

        profile_viewpager.adapter = viewPagerAdapter

    }

    override fun onDestroy() {

        super.onDestroy()


        app.releaseNavigationFragmentComponent()
    }



    override fun getContentView(): Int {

        return R.layout.fragment_home_profile

    }


}