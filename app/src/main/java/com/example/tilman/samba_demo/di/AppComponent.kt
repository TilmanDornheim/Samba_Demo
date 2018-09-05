package com.example.tilman.samba_demo.di

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.home.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ActivityModule::class))
interface AppComponent{

    fun inject(app: Samba)

    fun inject(activity: MainActivity)

}