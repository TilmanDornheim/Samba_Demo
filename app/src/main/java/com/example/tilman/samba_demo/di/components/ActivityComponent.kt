package com.example.tilman.samba_demo.di.components

import com.example.tilman.samba_demo.di.modules.ActivityModule
import com.example.tilman.samba_demo.di.scopes.ActivityScope
import com.example.tilman.samba_demo.mvp.home.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent{

    fun inject(activity: MainActivity)

}