package com.example.tilman.samba_demo.mvp.home.calendar

import com.example.tilman.samba_demo.data.models.Party
import com.example.tilman.samba_demo.data.repos.PartyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CalendarPresenterImpl(private var calendarView: CalendarContract.CalendarView?, private val partyRepository: PartyRepository): CalendarContract.CalendarPresenter{





    override fun onAttach() {


        partyRepository.getParties()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handlePartyResponse, this::handleError)

    }


    fun handlePartyResponse(parties: ArrayList<Party>){

        calendarView?.showToast("Received Parties")


    }

    fun handleError(throwable: Throwable){



    }

    override fun onDetach() {

        calendarView = null

    }






}