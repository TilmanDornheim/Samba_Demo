package com.example.tilman.samba_demo.mvp.home

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.home.MainActivityContract.View
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract
import com.example.tilman.samba_demo.mvp.home.calendar.HomeFragmentCalendarHolder
import com.example.tilman.samba_demo.mvp.home.map.HomeFragmentMap
import com.example.tilman.samba_demo.mvp.home.map.MapContract
import com.example.tilman.samba_demo.mvp.home.profile.HomeFragmentProfileHolder
import com.example.tilman.samba_demo.mvp.home.profile.ProfileContract
import com.example.tilman.samba_demo.utils.BottomNavOptions
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), View {


    @Inject
    lateinit var fragmentManager: FragmentManager

    @Inject
    lateinit var presenter: MainActivityContract.Presenter

    @Inject
    lateinit var calendarFrag: HomeFragmentCalendarHolder

    @Inject
    lateinit var profileFrag: HomeFragmentProfileHolder

    @Inject
    lateinit var mapFrag: HomeFragmentMap




    val app = Samba.getApplication()

    //Lifecycle methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        app.createActivityComponent(this)

        app.activityComponent!!.inject(this)

        presenter.onAttach()

        //Navigation listener

        main_activity_btm_nav_bar.selectedItemId = R.id.btm_nav_bar_calendar

        Log.d("BTM_NAV_BAR", "Selected Item Set to Calendar")

        main_activity_btm_nav_bar.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {

                R.id.btm_nav_bar_calendar -> {
                    presenter.navOptionClicked(BottomNavOptions.CALENDAR)
                    true

                }

                R.id.btm_nav_bar_profile -> {
                    presenter.navOptionClicked(BottomNavOptions.PROFILE)
                    true
                }

                R.id.btm_nav_bar_map -> {
                    presenter.navOptionClicked(BottomNavOptions.MAP)
                    true
                }

                else -> false


            }
        }


        main_activity_btm_nav_bar.setOnNavigationItemReselectedListener { item: MenuItem ->

            /**TODO|  Handle reselection logic. Need to get currently active tabLayout fragment in respective btm_nav_bar category
            *  TODO|  and invoke its reselection method. May require holder fragment to have its own presenter(Nav. logic vs Business logic)
            */
            when (item.itemId) {

                R.id.btm_nav_bar_calendar -> true

                R.id.btm_nav_bar_profile -> true

                R.id.btm_nav_bar_map -> true


                else -> false


            }

        }


    }


    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetach()

        app.releaseActivityComponent()

    }

    //Contract methods

    override fun showToast(text: String) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun showFragment(option: BottomNavOptions) {

        var transaction: FragmentTransaction = fragmentManager.beginTransaction()


        when (option) {

            BottomNavOptions.CALENDAR -> transaction.replace(R.id.main_activity_root_view, calendarFrag,"CalendarFragment")

            BottomNavOptions.PROFILE -> transaction.replace(R.id.main_activity_root_view, profileFrag,"ProfileFragment")

            BottomNavOptions.MAP -> transaction.replace(R.id.main_activity_root_view, mapFrag,"MapFragment")

        }


        transaction.commit()


    }


}
