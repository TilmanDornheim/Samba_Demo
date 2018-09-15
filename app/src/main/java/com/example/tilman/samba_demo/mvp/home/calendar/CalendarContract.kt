package com.example.tilman.samba_demo.mvp.home.calendar

import com.example.tilman.samba_demo.data.models.Party
import com.example.tilman.samba_demo.mvp.base.BaseContract
import com.example.tilman.samba_demo.mvp.base.BaseContract.BasePresenter
import com.example.tilman.samba_demo.mvp.base.BaseContract.BaseView

interface CalendarContract {


    interface CalendarView : BaseView {

        fun reselected()

        fun onPartyListUpdated()

    }

    interface CalendarPresenter : BasePresenter {


        fun showParties(): ArrayList<Party>

        //Attending

        fun showPartiesToday(): ArrayList<Party>

        fun showPartiesWeek(): ArrayList<Party>

        fun showPartiesLater(): ArrayList<Party>

        //Hosting

        fun showHostingToday(): ArrayList<Party>

        fun showHostingWeek(): ArrayList<Party>

        fun showHostingLater(): ArrayList<Party>



    }


}