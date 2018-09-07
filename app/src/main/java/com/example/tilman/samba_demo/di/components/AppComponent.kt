package com.example.tilman.samba_demo.di.components

import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.di.modules.ActivityModule

import com.example.tilman.samba_demo.di.modules.AppModule
import com.example.tilman.samba_demo.di.modules.NavigationFragmentModule
import com.example.tilman.samba_demo.mvp.home.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{

    fun inject(app: Samba)

    fun plus(activityModule: ActivityModule): ActivityComponent

    fun plus(navigationFragmentModule: NavigationFragmentModule): NavigationFragmentComponent

}