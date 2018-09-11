package com.example.tilman.samba_demo.mvp.home.calendar

import android.util.Log
import com.example.tilman.samba_demo.data.models.Party
import com.example.tilman.samba_demo.data.repos.PartyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class CalendarPresenterImpl(private var calendarView: CalendarContract.CalendarView?
                            , private val partyRepository: PartyRepository
                            , private val dateFormat: SimpleDateFormat) : CalendarContract.CalendarPresenter {


    private var partyList = ArrayList<Party>()


    override fun onAttach() {

        partyList.clear()

        loadParties()

    }

    fun loadParties() {

        partyRepository.getParties()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handlePartyResponse, this::handleError)
    }


    fun handlePartyResponse(parties: ArrayList<Party>) {

        partyList = parties

        calendarView?.onPartyListUpdated()


    }

    fun handleError(throwable: Throwable) {


    }

    override fun showParties(): ArrayList<Party> {

        return partyList

    }

    override fun showPartiesToday(): ArrayList<Party> {

        val calNow = Calendar.getInstance()

        val dayNow = calNow.get(Calendar.DAY_OF_YEAR)

        var dayList = ArrayList<Party>()

        partyList.forEach {


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

        partyList.forEach {


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

        partyList.forEach {


            val cal = Calendar.getInstance()

            cal.time = it.date

            if (!showPartiesToday().contains(it) && !showPartiesWeek().contains(it) && cal.time.after(calNow.time)) {


                laterList.add(it)

            }

        }

        return laterList

    }

    override fun onDetach() {

        calendarView = null


    }


}