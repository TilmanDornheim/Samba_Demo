package com.example.tilman.samba_demo.mvp.home.map

import com.example.tilman.samba_demo.data.repos.PartyRepository

class MapPresenterImpl(private var mapView: MapContract.MapView?,private val partyRepository: PartyRepository): MapContract.MapPresenter{


    override fun onAttach() {



    }

    override fun onDetach() {

        mapView = null

    }


}