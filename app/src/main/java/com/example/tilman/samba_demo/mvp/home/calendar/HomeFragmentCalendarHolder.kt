package com.example.tilman.samba_demo.mvp.home.calendar

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.CalendarViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home_calendar.*
import javax.inject.Inject

class HomeFragmentCalendarHolder: BaseFragment(){

    @Inject
    lateinit var viewPagerAdapter: CalendarViewPagerAdapter


    val app = Samba.getApplication()


    companion object {

        fun newInstance(): HomeFragmentCalendarHolder{

            val fragment = HomeFragmentCalendarHolder()

            //Add arguments as necessary

            return fragment

        }

    }


    override fun getContentView(): Int {

        return R.layout.fragment_home_calendar

    }

   override fun onCreate(savedInstanceState: Bundle?) {

       super.onCreate(savedInstanceState)

       app.createNavigationFragmentComponent(this)

       app.navigationFragmentComponent?.inject(this)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Tab Layout
        calendar_toolbar_tablayout.setTabTextColors(ContextCompat.getColor(context!!, R.color.tab_layout_not_selected), ContextCompat.getColor(context!!, R.color.white))


        //View Pager

        calendar_viewpager.adapter = viewPagerAdapter

        calendar_toolbar_tablayout.setupWithViewPager(calendar_viewpager)


    }


}