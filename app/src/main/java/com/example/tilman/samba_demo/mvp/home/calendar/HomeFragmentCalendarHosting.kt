package com.example.tilman.samba_demo.mvp.home.calendar

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.animation.AnimationUtils
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract.CalendarPresenter
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.attending.CalendarRecyclerAdapterAttendingLater
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.attending.CalendarRecyclerAdapterAttendingToday
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.attending.CalendarRecyclerAdapterAttendingWeek
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.hosting.CalendarRecyclerAdapterHostingLater
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.hosting.CalendarRecyclerAdapterHostingToday
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.hosting.CalendarRecyclerAdapterHostingWeek
import kotlinx.android.synthetic.main.fragment_home_calendar_attending.*
import javax.inject.Inject
import javax.inject.Named

class HomeFragmentCalendarHosting : BaseFragment(), CalendarContract.CalendarView {


    @Inject
    lateinit var presenter: CalendarPresenter

    @Inject
    lateinit var adapterHostingToday: CalendarRecyclerAdapterHostingToday

    @Inject
    lateinit var adapterHostingWeek: CalendarRecyclerAdapterHostingWeek

    @Inject
    lateinit var adapterHostingLater: CalendarRecyclerAdapterHostingLater

    @field:[Inject Named("LayoutManagerDay")]
    lateinit var layoutManagerDay: LinearLayoutManager

    @field:[Inject Named("LayoutManagerWeek")]
    lateinit var layoutManagerWeek: LinearLayoutManager

    @field:[Inject Named("LayoutManagerLater")]
    lateinit var layoutManagerLater: LinearLayoutManager


    val app = Samba.getApplication()

    var todayRecyclerShowing: Boolean = true

    var weekRecyclerShowing: Boolean = true

    var laterRecyclerShowing: Boolean = true


    companion object {

        fun newInstance(): HomeFragmentCalendarHosting {

            val fragment = HomeFragmentCalendarHosting()

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
        calendar_recyclerview_today.adapter = adapterHostingToday
        calendar_recyclerview_today.isNestedScrollingEnabled = false

        calendar_recyclerview_week.layoutManager = layoutManagerWeek
        calendar_recyclerview_week.adapter = adapterHostingWeek
        calendar_recyclerview_week.isNestedScrollingEnabled = false

        calendar_recyclerview_later.layoutManager = layoutManagerLater
        calendar_recyclerview_later.adapter = adapterHostingLater
        calendar_recyclerview_later.isNestedScrollingEnabled = false

        val animCollapse = AnimationUtils.loadAnimation(context,R.anim.calendar_collapse_arrow_anim)

        val animExpand = AnimationUtils.loadAnimation(context,R.anim.calendar_expand_arrow_anim)

        //Collapse & Expand logic for recyclerviews and arrows

        //Today

        when(todayRecyclerShowing){

            true -> {

                calendar_recyclerview_today.visibility = View.VISIBLE

                calendar_collapse_arrow_today.startAnimation(animExpand)

            }

            false -> {

                calendar_recyclerview_today.visibility = View.GONE

                calendar_collapse_arrow_today.startAnimation(animCollapse)

            }
        }

        calendar_collapse_arrow_today.setOnClickListener {

            when (todayRecyclerShowing) {

                true -> {

                    calendar_recyclerview_today.visibility = View.GONE

                    todayRecyclerShowing = false

                    calendar_collapse_arrow_today.startAnimation(animCollapse)

                }


                false -> {

                    calendar_recyclerview_today.visibility = View.VISIBLE

                    todayRecyclerShowing = true

                    calendar_collapse_arrow_today.startAnimation(animExpand)

                }

            }


        }


        //Week

        when(weekRecyclerShowing){

            true -> {

                calendar_recyclerview_week.visibility = View.VISIBLE

                calendar_collapse_arrow_week.startAnimation(animExpand)

            }

            false -> {

                calendar_recyclerview_week.visibility = View.GONE

                calendar_collapse_arrow_week.startAnimation(animCollapse)

            }

        }

        calendar_collapse_arrow_week.setOnClickListener {

            when(weekRecyclerShowing){

                true -> {

                    calendar_recyclerview_week.visibility = View.GONE

                    weekRecyclerShowing = false

                    calendar_collapse_arrow_week.startAnimation(animCollapse)

                }


                false -> {

                    calendar_recyclerview_week.visibility = View.VISIBLE

                    weekRecyclerShowing = true

                    calendar_collapse_arrow_week.startAnimation(animExpand)

                }


            }

        }

        //Later

        when(laterRecyclerShowing){

            true -> {

                calendar_recyclerview_later.visibility = View.VISIBLE
                calendar_collapse_arrow_later.startAnimation(animExpand)
            }

            false -> {

                calendar_recyclerview_later.visibility = View.GONE
                calendar_collapse_arrow_later.startAnimation(animCollapse)

            }

        }

        calendar_collapse_arrow_later.setOnClickListener {

            when(laterRecyclerShowing){

                true -> {

                    calendar_recyclerview_later.visibility = View.GONE

                    laterRecyclerShowing = false

                    calendar_collapse_arrow_later.startAnimation(animCollapse)

                }

                false -> {

                    calendar_recyclerview_later.visibility = View.VISIBLE

                    laterRecyclerShowing = true

                    calendar_collapse_arrow_later.startAnimation(animExpand)

                }

            }

        }




    }


    override fun onDestroy() {

        super.onDestroy()

        presenter.onDetach()

        app.releaseNavigationFragmentComponent()

    }

    override fun onPartyListUpdated() {

        adapterHostingToday.notifyDataSetChanged()
        adapterHostingWeek.notifyDataSetChanged()
        adapterHostingLater.notifyDataSetChanged()

    }


    override fun reselected() {


    }

    override fun getContentView(): Int {

        return R.layout.fragment_home_calendar_attending

    }


    override fun onPause() {

        super.onPause()



    }

    override fun onResume() {

        super.onResume()


    }

}