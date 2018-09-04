package com.example.tilman.samba_demo.mvp.base

interface BaseContract{

    interface BaseView{


    }

    interface BasePresenter{

        fun onAttach()

        fun onDetach()

    }


}