package com.example.tilman.samba_demo.di.modules

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.tilman.samba_demo.di.scopes.ActivityScope
import com.example.tilman.samba_demo.mvp.home.MainActivity
import com.example.tilman.samba_demo.mvp.home.MainActivityContract
import com.example.tilman.samba_demo.mvp.home.MainActivityPresenter
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendar
import com.example.tilman.samba_demo.mvp.home.map.HomeFragmentMap
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfile
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: MainActivity){

    @Provides
    @ActivityScope
    fun provideActivity() = activity

    @Provides
    @ActivityScope
    fun providesFragmentManager(activity: MainActivity): FragmentManager{


        return activity.supportFragmentManager

    }

    @Provides
    @ActivityScope
    fun providePresenter(activity: MainActivity): MainActivityContract.Presenter {


        return MainActivityPresenter(activity as MainActivityContract.View)

    }

    @Provides
    @ActivityScope
    fun provideCalendarFragment(): HomeFragmentCalendar{

        return HomeFragmentCalendar()

    }

    @Provides
    @ActivityScope
    fun provideProfileFragment(): HomeFragmentProfile {

        return HomeFragmentProfile()

    }

    @Provides
    @ActivityScope
    fun provideMapFragment(): HomeFragmentMap {

        return HomeFragmentMap()

    }


}