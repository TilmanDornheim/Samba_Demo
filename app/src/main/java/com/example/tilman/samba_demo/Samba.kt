package com.example.tilman.samba_demo

import android.app.Application
import com.example.tilman.samba_demo.di.AppComponent
import com.example.tilman.samba_demo.di.AppModule
import com.example.tilman.samba_demo.di.DaggerAppComponent

class Samba : Application(){


    val appComponent: AppComponent by lazy {

        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

    }

    override fun onCreate() {

        super.onCreate()

        appComponent.inject(this)


    }






}