package com.example.tilman.samba_demo.mvp.home

import android.app.Application
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.di.modules.ActivityModule
import com.example.tilman.samba_demo.mvp.home.MainActivityContract.View
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendar
import com.example.tilman.samba_demo.mvp.home.map.HomeFragmentMap
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfile
import com.example.tilman.samba_demo.utils.BottomNavOptions
import kotlinx.android.synthetic.main.activity_main.*
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

        //Navigation listener

        main_activity_btm_nav_bar.selectedItemId = R.id.btm_nav_bar_calendar

        Log.d("BTM_NAV_BAR", "Selected Item Set to Calendar")

        main_activity_btm_nav_bar.setOnNavigationItemSelectedListener { item: MenuItem ->
            when(item.itemId){

                R.id.btm_nav_bar_calendar -> {
                    presenter.navOptionClicked(BottomNavOptions.CALENDAR)
                    Log.d("BTM_NAV_BAR", "Selected Calendar")
                    true

                }

                R.id.btm_nav_bar_profile -> {
                    presenter.navOptionClicked(BottomNavOptions.PROFILE)
                    Log.d("BTM_NAV_BAR", "Selected Profile")
                    true
                }

                R.id.btm_nav_bar_map -> {
                    presenter.navOptionClicked(BottomNavOptions.MAP)
                    Log.d("BTM_NAV_BAR", "Selected Map")
                    true
                }

                else -> {

                    Log.d("BTM_NAV_BAR", "Selected Nothing")
                    false

                }


            }
        }


        main_activity_btm_nav_bar.setOnNavigationItemReselectedListener { item: MenuItem ->

            when(item.itemId){

                R.id.btm_nav_bar_calendar -> {

                    Log.d("BTM_NAV_BAR", "Reselected Calendar")
                    true
                }

                R.id.btm_nav_bar_profile -> {

                    Log.d("BTM_NAV_BAR", "Reselected Profile")
                    true

                }

                R.id.btm_nav_bar_map -> {

                    Log.d("BTM_NAV_BAR", "Reselected Map")
                    true

                }

                else -> false



            }

        }







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

            BottomNavOptions.CALENDAR -> transaction.replace(R.id.main_activity_root_view, calendarFragment)

            BottomNavOptions.PROFILE -> transaction.replace(R.id.main_activity_root_view, profileFragment)

            BottomNavOptions.MAP -> transaction.replace(R.id.main_activity_root_view, mapFragment)

        }

        transaction.commit()


    }




}
