package com.example.tilman.samba_demo.mvp.home.calendar

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract.CalendarPresenter
import kotlinx.android.synthetic.main.fragment_home_calendar.*
import javax.inject.Inject

class HomeFragmentCalendar : BaseFragment(), CalendarContract.CalendarView{


    @Inject
    lateinit var presenter: CalendarPresenter

    @Inject
    lateinit var adapter: CalendarRecyclerAdapter

    @Inject
    lateinit var layoutManager: LinearLayoutManager

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

        calendar_recyclerview.layoutManager = layoutManager
        calendar_recyclerview.adapter = adapter


    }



    override fun onDestroy() {

        super.onDestroy()

        presenter.onDetach()

        app.releaseNavigationFragmentComponent()

    }

    override fun onPartyListUpdated() {

        adapter.notifyDataSetChanged()

    }


    override fun reselected() {



    }

    override fun getContentView(): Int {

        return R.layout.fragment_home_calendar

    }


}