package com.example.tilman.samba_demo.mvp.home.calendar

import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract.CalendarPresenter
import kotlinx.android.synthetic.main.fragment_home_calendar.*
import javax.inject.Inject
import javax.inject.Named

class HomeFragmentCalendar : BaseFragment(), CalendarContract.CalendarView {


    @Inject
    lateinit var presenter: CalendarPresenter

    @Inject
    lateinit var adapterToday: CalendarRecyclerAdapterToday

    @Inject
    lateinit var adapterWeek: CalendarRecyclerAdapterWeek

    @Inject
    lateinit var adapterLater: CalendarRecyclerAdapterLater

    @field:[Inject Named("LayoutManagerDay")]
    lateinit var layoutManagerDay: LinearLayoutManager

    @field:[Inject Named("LayoutManagerWeek")]
    lateinit var layoutManagerWeek: LinearLayoutManager

    @field:[Inject Named("LayoutManagerLater")]
    lateinit var layoutManagerLater: LinearLayoutManager


    val app = Samba.getApplication()

    val scrollPosition = intArrayOf(0, 0)

    var todayRecyclerShowing: Boolean = true

    var weekRecyclerShowing: Boolean = true

    var laterRecyclerShowing: Boolean = true


    companion object {

        fun newInstance(): HomeFragmentCalendar {

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

        calendar_recyclerview_later.layoutManager = layoutManagerLater
        calendar_recyclerview_later.adapter = adapterLater
        calendar_recyclerview_later.isNestedScrollingEnabled = false

        val animCollapse = AnimationUtils.loadAnimation(context,R.anim.calendar_collapse_arrow_anim)

        val animExpand = AnimationUtils.loadAnimation(context,R.anim.calendar_expand_arrow_anim)

        //Collapse & Expand logic for recyclerviews

        //Today

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

        adapterToday.notifyDataSetChanged()
        adapterWeek.notifyDataSetChanged()
        adapterLater.notifyDataSetChanged()

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