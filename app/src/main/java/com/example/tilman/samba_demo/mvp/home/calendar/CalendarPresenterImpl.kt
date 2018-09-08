package com.example.tilman.samba_demo.mvp.home.calendar

import android.util.Log
import com.example.tilman.samba_demo.data.models.Party
import com.example.tilman.samba_demo.data.repos.PartyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CalendarPresenterImpl(private var calendarView: CalendarContract.CalendarView?, private val partyRepository: PartyRepository): CalendarContract.CalendarPresenter{



    private var partyList = ArrayList<Party>()




    override fun onAttach() {

        Log.d("Calendar Frag", "Presenter onAttach called")

        partyList.clear()

        loadParties()

    }

    fun loadParties() {

        partyRepository.getParties()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handlePartyResponse, this::handleError)
    }


    fun handlePartyResponse(parties: ArrayList<Party>){

        Log.d("Calendar Frag", "# of received Parties = " + parties.size)

        partyList = parties

        calendarView?.onPartyListUpdated()




    }

    fun handleError(throwable: Throwable){



    }

    override fun showParties(): ArrayList<Party> {

        return partyList

    }

    override fun onDetach() {

        calendarView = null

        Log.d("Calendar Frag","Presenter onDetach called")

    }






}