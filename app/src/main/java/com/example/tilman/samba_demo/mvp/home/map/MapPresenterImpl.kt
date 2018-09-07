package com.example.tilman.samba_demo.mvp.home.map

class MapPresenterImpl(private var mapView: MapContract.MapView?): MapContract.MapPresenter{


    override fun onAttach() {

        mapView?.showToast("Map Presenter attached")

    }

    override fun onDetach() {

        mapView = null

    }


}