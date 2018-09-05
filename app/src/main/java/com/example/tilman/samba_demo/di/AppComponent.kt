package com.example.tilman.samba_demo.di

import android.app.Application
import com.example.tilman.samba_demo.mvp.home.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent{

    fun inject(app: Application)

}