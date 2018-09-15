package com.example.tilman.samba_demo.mvp.home.calendar

import com.example.tilman.samba_demo.data.models.Party
import com.example.tilman.samba_demo.data.repos.PartyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarPresenterImpl(private var calendarView: CalendarContract.CalendarView?
                            , private val partyRepository: PartyRepository
                            , private val dateFormat: SimpleDateFormat) : CalendarContract.CalendarPresenter {


    private var partyAttendingList = ArrayList<Party>()

    private var partyHostingList = ArrayList<Party>()


    override fun onAttach() {

        partyAttendingList.clear()
        partyHostingList.clear()

        loadParties()

    }

    fun loadParties() {

        partyRepository.getAttendingParties()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handlePartyResponse, this::handleError)

        partyRepository.getHostingParties()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleHostingResponse, this::handleError)
    }


    fun handlePartyResponse(parties: ArrayList<Party>) {

        partyAttendingList = parties

        calendarView?.onPartyListUpdated()


    }

    fun handleHostingResponse(parties: ArrayList<Party>){

        partyHostingList = parties

        calendarView?.onPartyListUpdated()

    }

    fun handleError(throwable: Throwable) {


    }

    override fun showParties(): ArrayList<Party> {

        return partyAttendingList

    }

    override fun showPartiesToday(): ArrayList<Party> {

        val calNow = Calendar.getInstance()

        val dayNow = calNow.get(Calendar.DAY_OF_YEAR)

        var dayList = ArrayList<Party>()

        partyAttendingList.forEach {


            val cal = Calendar.getInstance()

            cal.time = it.date

            val partyDay = cal.get(Calendar.DAY_OF_YEAR)

            if (dayNow == partyDay) {


                dayList.add(it)

            }

        }


        return dayList


    }

    override fun showPartiesWeek(): ArrayList<Party> {

        val calNow = Calendar.getInstance()

        val weekNow = calNow.get(Calendar.WEEK_OF_YEAR)

        var weekList = ArrayList<Party>()

        partyAttendingList.forEach {


            val cal = Calendar.getInstance()

            cal.time = it.date

            val partyWeek = cal.get(Calendar.WEEK_OF_YEAR)

            if (weekNow == partyWeek && !showPartiesToday().contains(it)) {

                weekList.add(it)

            }


        }


        return weekList

    }


    override fun showPartiesLater(): ArrayList<Party> {

        val calNow = Calendar.getInstance()

        val laterList = ArrayList<Party>()

        partyAttendingList.forEach {


            val cal = Calendar.getInstance()

            cal.time = it.date

            if (!showPartiesToday().contains(it) && !showPartiesWeek().contains(it) && cal.time.after(calNow.time)) {


                laterList.add(it)

            }

        }

        return laterList

    }


    override fun showHostingToday(): ArrayList<Party> {

        val calNow = Calendar.getInstance()

        val dayNow = calNow.get(Calendar.DAY_OF_YEAR)

        val todayList = ArrayList<Party>()

        partyHostingList.forEach {

            val cal = Calendar.getInstance()

            cal.time = it.date

            if(dayNow == cal.get(Calendar.DAY_OF_YEAR)){

                todayList.add(it)

            }

        }

        return todayList

    }

    override fun showHostingWeek(): ArrayList<Party> {


        val calNow = Calendar.getInstance()

        val weekNow = calNow.get(Calendar.WEEK_OF_YEAR)

        val weekList = ArrayList<Party>()

        partyHostingList.forEach {

            val cal = Calendar.getInstance()

            cal.time = it.date

            if(!showHostingToday().contains(it) && weekNow == cal.get(Calendar.WEEK_OF_YEAR)){

                weekList.add(it)

            }

        }

        return weekList

    }

    override fun showHostingLater(): ArrayList<Party> {

        val calNow = Calendar.getInstance()

        val laterList = ArrayList<Party>()

        partyHostingList.forEach {

            val cal = Calendar.getInstance()

            cal.time = it.date

            if(!showHostingToday().contains(it) && !showHostingWeek().contains(it) && cal.time.after(calNow.time)){

                laterList.add(it)

            }

        }

        return laterList

    }



    override fun onDetach() {

        calendarView = null


    }


}