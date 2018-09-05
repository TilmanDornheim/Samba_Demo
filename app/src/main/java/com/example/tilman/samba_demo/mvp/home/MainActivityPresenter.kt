package com.example.tilman.samba_demo.mvp.home

import com.example.tilman.samba_demo.utils.BottomNavOptions
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(private val view: MainActivityContract.View): MainActivityContract.Presenter{



    override fun navOptionClicked(option: BottomNavOptions) {

        when(option){

            BottomNavOptions.CALENDAR -> view.showFragment(BottomNavOptions.CALENDAR)

            BottomNavOptions.PROFILE -> view.showFragment(BottomNavOptions.PROFILE)

            BottomNavOptions.MAP -> view.showFragment(BottomNavOptions.MAP)


        }


    }


    override fun onAttach() {

        view.showFragment(BottomNavOptions.CALENDAR)

    }

    override fun onDetach() {



    }


}