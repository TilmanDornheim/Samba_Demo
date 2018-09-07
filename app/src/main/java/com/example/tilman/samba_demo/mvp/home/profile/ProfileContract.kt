package com.example.tilman.samba_demo.mvp.home.profile

import com.example.tilman.samba_demo.mvp.base.BaseContract
import com.example.tilman.samba_demo.mvp.base.BaseContract.BasePresenter
import com.example.tilman.samba_demo.mvp.base.BaseContract.BaseView

interface ProfileContract{


    interface ProfileView: BaseView{

        fun reselected()

    }


    interface ProfilePresenter: BasePresenter{



    }

}