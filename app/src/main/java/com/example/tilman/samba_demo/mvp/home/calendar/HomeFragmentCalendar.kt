package com.example.tilman.samba_demo.mvp.home.calendar

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract.CalendarPresenter
import kotlinx.android.synthetic.main.fragment_home_calendar.*
import javax.inject.Inject
import javax.inject.Named

class HomeFragmentCalendar : BaseFragment(), CalendarContract.CalendarView{


    @Inject
    lateinit var presenter: CalendarPresenter

    @Inject
    lateinit var adapterToday: CalendarRecyclerAdapterToday

    @Inject
    lateinit var adapterWeek: CalendarRecyclerAdapterWeek

    @field:[Inject Named("LayoutManagerDay")]
    lateinit var layoutManagerDay: LinearLayoutManager

    @field:[Inject Named("LayoutManagerWeek")]
    lateinit var layoutManagerWeek: LinearLayoutManager

    val app = Samba.getApplication()




    companion object {

        fun newInstance(): HomeFragmentCalendar{

            val fragment = HomeFragmentCalendar()

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

        presenter.onAttach()

        calendar_recyclerview_today.layoutManager = layoutManagerDay
        calendar_recyclerview_today.adapter = adapterToday
        calendar_recyclerview_today.isNestedScrollingEnabled = false

        calendar_recyclerview_week.layoutManager = layoutManagerWeek
        calendar_recyclerview_week.adapter = adapterWeek
        calendar_recyclerview_week.isNestedScrollingEnabled = false




    }



    override fun onDestroy() {

        super.onDestroy()

        presenter.onDetach()

        app.releaseNavigationFragmentComponent()

    }

    override fun onPartyListUpdated() {

        adapterToday.notifyDataSetChanged()

    }


    override fun reselected() {




    }

    override fun getContentView(): Int {

        return R.layout.fragment_home_calendar

    }


    override fun onPause() {

        super.onPause()



    }

    override fun onResume() {

        super.onResume()





    }

}