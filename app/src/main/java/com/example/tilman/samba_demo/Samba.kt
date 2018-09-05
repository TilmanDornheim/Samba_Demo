package com.example.tilman.samba_demo

import android.app.Application
import com.example.tilman.samba_demo.di.components.ActivityComponent
import com.example.tilman.samba_demo.di.components.AppComponent
import com.example.tilman.samba_demo.di.modules.AppModule

import com.example.tilman.samba_demo.di.components.DaggerAppComponent
import com.example.tilman.samba_demo.di.modules.ActivityModule
import com.example.tilman.samba_demo.mvp.home.MainActivity

class Samba : Application(){

    init {
        instance = this
    }

    companion object {

        private var instance: Samba? = null

        fun getApplication(): Samba{

            return instance!!

        }

    }


    val appComponent: AppComponent by lazy {

        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    var activityComponent: ActivityComponent? = null



    override fun onCreate() {

        super.onCreate()

        appComponent.inject(this)


    }

    fun createActivityComponent(activity: MainActivity): ActivityComponent {

        activityComponent = appComponent.plus(ActivityModule(activity))

        return activityComponent as ActivityComponent


    }

    fun releaseActivityComponent(){

        activityComponent = null

    }








}