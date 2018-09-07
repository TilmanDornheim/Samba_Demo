package com.example.tilman.samba_demo.di.components

import com.example.tilman.samba_demo.di.modules.NavigationFragmentModule
import com.example.tilman.samba_demo.di.scopes.NavigationFragmentScope
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendar
import com.example.tilman.samba_demo.mvp.home.map.HomeFragmentMap
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfile
import dagger.Component
import dagger.Subcomponent

@NavigationFragmentScope
@Subcomponent(modules = [NavigationFragmentModule::class])
interface NavigationFragmentComponent{


    fun inject(calendarFrag: HomeFragmentCalendar)
    fun inject(profileFrag: HomeFragmentProfile)
    fun inject(mapFrag: HomeFragmentMap)


}