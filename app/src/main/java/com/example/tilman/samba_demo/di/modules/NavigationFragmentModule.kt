package com.example.tilman.samba_demo.di.modules

import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import com.example.tilman.samba_demo.data.repos.PartyRepository
import com.example.tilman.samba_demo.di.scopes.NavigationFragmentScope
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.example.tilman.samba_demo.mvp.home.calendar.*
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.attending.CalendarRecyclerAdapterAttendingLater
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.attending.CalendarRecyclerAdapterAttendingToday
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.attending.CalendarRecyclerAdapterAttendingWeek
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.CalendarViewPagerAdapter
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.hosting.CalendarRecyclerAdapterHostingLater
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.hosting.CalendarRecyclerAdapterHostingToday
import com.example.tilman.samba_demo.mvp.home.calendar.adapters.hosting.CalendarRecyclerAdapterHostingWeek
import com.example.tilman.samba_demo.mvp.home.map.MapContract
import com.example.tilman.samba_demo.mvp.home.map.MapPresenterImpl
import com.example.tilman.samba_demo.mvp.home.profile.ProfileContract
import com.example.tilman.samba_demo.mvp.home.profile.ProfilePresenterImpl
import com.example.tilman.samba_demo.mvp.home.profile.ProfileViewPagerAdapter
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
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
    @Named("LayoutManagerLater")
    fun provideLinearLayoutManagerLater(): LinearLayoutManager{

        return LinearLayoutManager(fragment.context)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerAdapterToday(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterAttendingToday {

        return CalendarRecyclerAdapterAttendingToday(presenter)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerAdapterWeek(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterAttendingWeek {

        return CalendarRecyclerAdapterAttendingWeek(presenter)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerAdapterLater(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterAttendingLater {

        return CalendarRecyclerAdapterAttendingLater(presenter)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerHostingAdapterToday(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterHostingToday{

        return CalendarRecyclerAdapterHostingToday(presenter)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerHostingAdapterWeek(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterHostingWeek {

        return CalendarRecyclerAdapterHostingWeek(presenter)

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarRecyclerHostingAdapterLater(presenter: CalendarContract.CalendarPresenter): CalendarRecyclerAdapterHostingLater{

        return CalendarRecyclerAdapterHostingLater(presenter)

    }

    @NavigationFragmentScope
    @Provides
    fun provideChildFragmentManager(fragment: BaseFragment): android.support.v4.app.FragmentManager{

        return fragment.childFragmentManager

    }

    @NavigationFragmentScope
    @Provides
    fun provideCalendarViewPagerAdapter(fragmentManager: android.support.v4.app.FragmentManager): CalendarViewPagerAdapter {

        return CalendarViewPagerAdapter(fragmentManager)

    }


    @NavigationFragmentScope
    @Provides
    fun providesProfileViewPagerAdapter(fragmentManager: FragmentManager): ProfileViewPagerAdapter{


        return ProfileViewPagerAdapter(fragmentManager)

    }



}