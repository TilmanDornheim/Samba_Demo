package com.example.tilman.samba_demo.mvp.home

import com.example.tilman.samba_demo.utils.BottomNavOptions
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(private val view: MainActivityContract.View): MainActivityContract.Presenter{





    override fun onAttach() {

        view.showFragment(BottomNavOptions.MAP)

    }

    override fun onDetach() {



    }


}