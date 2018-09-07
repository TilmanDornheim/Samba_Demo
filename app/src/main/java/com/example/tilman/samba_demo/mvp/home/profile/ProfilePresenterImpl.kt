package com.example.tilman.samba_demo.mvp.home.profile

class ProfilePresenterImpl(private var profileView: ProfileContract.ProfileView?): ProfileContract.ProfilePresenter{


    override fun onAttach() {

        profileView?.showToast("Profile Presenter attached")

    }

    override fun onDetach() {

        profileView = null

    }


}