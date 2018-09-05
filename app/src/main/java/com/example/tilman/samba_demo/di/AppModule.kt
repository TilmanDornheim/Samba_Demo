package com.example.tilman.samba_demo.di

import android.app.Application
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application){

    @Provides
    @Singleton
    fun provideApplication() = app







}