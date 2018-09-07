package com.example.tilman.samba_demo.mvp.home.profile

import com.example.tilman.samba_demo.data.repos.PartyRepository

class ProfilePresenterImpl(private var profileView: ProfileContract.ProfileView?, private val partyRepository: PartyRepository): ProfileContract.ProfilePresenter{


    override fun onAttach() {



    }

    override fun onDetach() {

        profileView = null

    }


}