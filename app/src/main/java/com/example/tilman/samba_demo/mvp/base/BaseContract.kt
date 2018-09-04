package com.example.tilman.samba_demo.mvp.base

interface BaseContract{

    interface BaseView{

        fun showToast(text: String)


    }

    interface BasePresenter{

        fun onAttach()

        fun onDetach()

    }


}