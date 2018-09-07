package com.example.tilman.samba_demo.mvp.home.calendar

import com.example.tilman.samba_demo.mvp.base.BaseContract
import com.example.tilman.samba_demo.mvp.base.BaseContract.BasePresenter
import com.example.tilman.samba_demo.mvp.base.BaseContract.BaseView

interface CalendarContract {


    interface CalendarView : BaseView {

        fun reselected()

    }

    interface CalendarPresenter : BasePresenter {



    }


}