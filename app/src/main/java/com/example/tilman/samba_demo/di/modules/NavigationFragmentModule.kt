package com.example.tilman.samba_demo.di.modules

import android.support.v7.widget.LinearLayoutManager
import com.example.tilman.samba_demo.data.repos.PartyRepository
import com.example.tilman.samba_demo.di.scopes.NavigationFragmentScope
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarPresenterImpl
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarRecyclerAdapterToday
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarRecyclerAdapterWeek
import com.example.tilman.samba_demo.mvp.home.map.MapContract
import com.example.tilman.samba_demo.mvp.home.map.MapPresenterImpl
import com.example.tilman.samba_demo.mvp.home.profile.ProfileContract
import com.example.tilman.samba_demo.mvp.home.profile.ProfilePresenterImpl
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Named

@Module
class NavigationFragmentModule(private val fragment: BaseFragment){


    @NavigationFragmentScope
    @Provides
    fun provideFragment() = fragment


    @NavigationFragmentScope
    @Provides
    fun provideCalendarPresenter(fragment: BaseFragment, partyRepository: PartyRepository, dateFormat: SimpleDateFormat): CalendarContract.CalendarPresenter {


        return CalendarPresenterImpl(fragment as CalendarContract.CalendarView, partyRepository, dateFormat)

    }


    @NavigationFragmentScope
    @Provides
    fun provideProfilePresenter(fragment: BaseFragment, partyRepository: PartyRepository): ProfileContract.ProfilePresenter{


        return ProfilePresenterImpl(fragment as ProfileContract.ProfileView, partyRepository)

    }

    @NavigationFragmentScope
    @Provides
    fun provideMapPresenter(fragment: BaseFragment, partyRepository: PartyRepository): MapContract.MapPresenter{


        return MapPresenterImpl(fragment as MapContract.MapView, partyRepository)

    }

    @NavigationFragmentScope
    @Provides
    @Named("LayoutManagerDay")
    fun provideLinearLayoutManagerDay(): LinearLayoutManager{

        return LinearLayoutManager(fragment.context)

    }

    @NavigationFragmentScope
    @Provides
    @Named("LayoutManagerWeek")
    fun provideLinearLayoutManagerWeek(): LinearLayoutManager{

        return LinearLayoutManager(fragment.context)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerAdapterToday(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterToday{

        return CalendarRecyclerAdapterToday(presenter)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerAdapterWeek(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterWeek{

        return CalendarRecyclerAdapterWeek(presenter)

    }



}