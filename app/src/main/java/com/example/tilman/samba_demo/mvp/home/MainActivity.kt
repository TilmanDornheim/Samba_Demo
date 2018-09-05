package com.example.tilman.samba_demo.mvp.home

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.di.modules.ActivityModule
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject lateinit var fragmentManager: FragmentManager

    private val app : Samba = application as Samba


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        app.appComponent.plus(ActivityModule(this))

        app.activityComponent?.inject(this)

    }




}
