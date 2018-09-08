package com.example.tilman.samba_demo.di.modules

import android.support.v7.widget.LinearLayoutManager
import com.example.tilman.samba_demo.data.repos.PartyRepository
import com.example.tilman.samba_demo.di.scopes.NavigationFragmentScope
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarPresenterImpl
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarRecyclerAdapter
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendar
import com.example.tilman.samba_demo.mvp.home.map.MapContract
import com.example.tilman.samba_demo.mvp.home.map.MapPresenterImpl
import com.example.tilman.samba_demo.mvp.home.profile.ProfileContract
import com.example.tilman.samba_demo.mvp.home.profile.ProfilePresenterImpl
import dagger.Module
import dagger.Provides

@Module
class NavigationFragmentModule(private val fragment: BaseFragment){


    @NavigationFragmentScope
    @Provides
    fun provideFragment() = fragment


    @NavigationFragmentScope
    @Provides
    fun provideCalendarPresenter(fragment: BaseFragment, partyRepository: PartyRepository): CalendarContract.CalendarPresenter {


        return CalendarPresenterImpl(fragment as CalendarContract.CalendarView, partyRepository)

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
    fun provideLinearLayoutManager(): LinearLayoutManager{

        return LinearLayoutManager(fragment.context)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerAdapter(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapter{

        return CalendarRecyclerAdapter(presenter)

    }



}