package com.example.tilman.samba_demo.mvp.home.calendar

class CalendarPresenterImpl(private var calendarView: CalendarContract.CalendarView?): CalendarContract.CalendarPresenter{





    override fun onAttach() {

        calendarView?.showToast("Calendar Presenter Attached")

    }

    override fun onDetach() {

        calendarView = null

    }






}