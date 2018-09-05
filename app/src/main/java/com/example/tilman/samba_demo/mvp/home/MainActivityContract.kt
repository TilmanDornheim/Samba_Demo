package com.example.tilman.samba_demo.mvp.home

import com.example.tilman.samba_demo.mvp.base.BaseContract
import com.example.tilman.samba_demo.mvp.base.BaseContract.BasePresenter
import com.example.tilman.samba_demo.mvp.base.BaseContract.BaseView
import com.example.tilman.samba_demo.utils.BottomNavOptions

interface MainActivityContract {

    interface View : BaseView{

        fun showFragment(option: BottomNavOptions)

    }

    interface Presenter :BasePresenter {

        fun navOptionClicked(option: BottomNavOptions)

    }




}