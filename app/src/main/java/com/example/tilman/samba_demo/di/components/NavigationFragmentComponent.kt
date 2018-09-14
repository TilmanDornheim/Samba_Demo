package com.example.tilman.samba_demo.di.components

import com.example.tilman.samba_demo.di.modules.NavigationFragmentModule
import com.example.tilman.samba_demo.di.scopes.NavigationFragmentScope
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarAttending
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarHolder
import com.example.tilman.samba_demo.mvp.home.map.HomeFragmentMap
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfile
import dagger.Subcomponent

@NavigationFragmentScope
@Subcomponent(modules = [NavigationFragmentModule::class])
interface NavigationFragmentComponent{


    fun inject(calendarHolderFrag: HomeFragmentCalendarHolder)
    fun inject(calendarFrag: HomeFragmentCalendarAttending)
    fun inject(profileFrag: HomeFragmentProfile)
    fun inject(mapFrag: HomeFragmentMap)


}