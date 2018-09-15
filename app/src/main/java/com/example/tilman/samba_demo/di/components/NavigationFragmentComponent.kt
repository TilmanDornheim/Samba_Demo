package com.example.tilman.samba_demo.di.components

import com.example.tilman.samba_demo.di.modules.NavigationFragmentModule
import com.example.tilman.samba_demo.di.scopes.NavigationFragmentScope
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarAttending
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarHolder
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarHosting
import com.example.tilman.samba_demo.mvp.home.map.HomeFragmentMap
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfileAccount
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfileHistory
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfileHolder
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfileSettings
import dagger.Subcomponent

@NavigationFragmentScope
@Subcomponent(modules = [NavigationFragmentModule::class])
interface NavigationFragmentComponent{


    fun inject(calendarHolderFrag: HomeFragmentCalendarHolder)
    fun inject(calendarAttendingFrag: HomeFragmentCalendarAttending)
    fun inject(calendarHostingFrag: HomeFragmentCalendarHosting)
    fun inject(profileHolderFrag: HomeFragmentProfileHolder)
    fun inject(mapFrag: HomeFragmentMap)
    fun inject(profileAccountFrag: HomeFragmentProfileAccount)
    fun inject(profileHistoryFrag: HomeFragmentProfileHistory)
    fun inject(profileSettingsFrag: HomeFragmentProfileSettings)


}