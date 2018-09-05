package com.example.tilman.samba_demo.di

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: AppCompatActivity){


    @Provides
    @Singleton
    fun provideActivity() = activity

    @Provides
    @Singleton
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager{


        return activity.supportFragmentManager

    }


}