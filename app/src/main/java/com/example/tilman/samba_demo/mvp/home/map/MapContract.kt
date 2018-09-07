package com.example.tilman.samba_demo.mvp.home.map

import com.example.tilman.samba_demo.mvp.base.BaseContract
import com.example.tilman.samba_demo.mvp.base.BaseContract.BasePresenter
import com.example.tilman.samba_demo.mvp.base.BaseContract.BaseView

interface MapContract{

    interface MapView: BaseView{

        fun reselected()

    }

    interface MapPresenter: BasePresenter{



    }

}