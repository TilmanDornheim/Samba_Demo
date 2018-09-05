package com.example.tilman.samba_demo.di.modules

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.tilman.samba_demo.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity){

    @Provides
    @ActivityScope
    fun provideActivity() = activity

    @Provides
    @ActivityScope
    fun providesFragmentManager(activity: AppCompatActivity): FragmentManager{


        return activity.supportFragmentManager

    }


}