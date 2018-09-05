package com.example.tilman.samba_demo.mvp.home

import android.app.Application
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.di.modules.ActivityModule
import com.example.tilman.samba_demo.mvp.home.MainActivityContract.View
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendar
import com.example.tilman.samba_demo.mvp.home.map.HomeFragmentMap
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfile
import com.example.tilman.samba_demo.utils.BottomNavOptions
import javax.inject.Inject


class MainActivity : AppCompatActivity(), View {



    @Inject lateinit var fragmentManager: FragmentManager

    @Inject lateinit var presenter: MainActivityContract.Presenter

    @Inject lateinit var calendarFragment: HomeFragmentCalendar

    @Inject lateinit var profileFragment: HomeFragmentProfile

    @Inject lateinit var mapFragment: HomeFragmentMap



    //Lifecycle methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val app = Samba.getApplication()

        app.createActivityComponent(this)

        app.activityComponent!!.inject(this)

        presenter.onAttach()



    }



    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetach()

    }

    //Contract methods

    override fun showToast(text: String) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun showFragment(option: BottomNavOptions) {

        var transaction: FragmentTransaction = fragmentManager.beginTransaction()

        when(option){

            BottomNavOptions.CALENDAR -> transaction.add(R.id.main_activity_root_view, calendarFragment)

            BottomNavOptions.PROFILE -> transaction.add(R.id.main_activity_root_view, profileFragment)

            BottomNavOptions.MAP -> transaction.add(R.id.main_activity_root_view, mapFragment)

        }

        transaction.commit()


    }




}
