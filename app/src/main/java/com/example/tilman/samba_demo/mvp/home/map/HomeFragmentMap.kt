package com.example.tilman.samba_demo.mvp.home.map

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_home_map.*
import java.util.jar.Manifest
import javax.inject.Inject

class HomeFragmentMap : BaseFragment(), MapContract.MapView, OnMapReadyCallback, LocationListener {

    @Inject
    lateinit var presenter: MapContract.MapPresenter


    @Inject
    lateinit var criteria: Criteria

    val app = Samba.getApplication()

    var googleMap: GoogleMap? = null

    companion object {

        fun newInstance(): HomeFragmentMap {

            val fragment = HomeFragmentMap()

            //Add arguments as necessary

            return fragment


        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        app.createNavigationFragmentComponent(this)

        app.navigationFragmentComponent?.inject(this)

        presenter.onAttach()



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        map_mapview.onCreate(savedInstanceState?.getBundle("MapViewBundleKey"))

        map_mapview.getMapAsync(this)

    }

    override fun onDestroy() {

        super.onDestroy()


        presenter.onDetach()

        app.releaseNavigationFragmentComponent()
    }

    override fun onStop() {

        super.onStop()

        map_mapview.onStop()
    }

    override fun onStart() {

        super.onStart()

        map_mapview.onStart()
    }

    override fun onPause() {

        super.onPause()

        map_mapview.onPause()
    }

    override fun onResume() {

        super.onResume()

        map_mapview.onResume()
    }


    override fun reselected() {



    }


    override fun onMapReady(map: GoogleMap?) {

        googleMap = map

        googleMap?.setMinZoomPreference(12f)

        //Permission check and potentially request

        val permission = ContextCompat.checkSelfPermission(context!!, android.Manifest.permission.ACCESS_FINE_LOCATION)

        if(permission != PackageManager.PERMISSION_GRANTED){

            requestPermission()

            onMapReady(googleMap)

        }

        else {


            //Location Setup

            googleMap?.isMyLocationEnabled = true

            googleMap?.uiSettings?.isMyLocationButtonEnabled = true

            val locationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            val provider = locationManager.getBestProvider(criteria, false)

            val location = locationManager.getLastKnownLocation(provider)

            if(location!=null){

                onLocationChanged(location)

            }

            locationManager.requestLocationUpdates(provider,10000,0f, this)



        }

    }

    override fun onLocationChanged(location: Location?) {

        val myLocation = LatLng(location!!.latitude, location.longitude)

        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(myLocation))

        googleMap?.animateCamera(CameraUpdateFactory.zoomTo(15f))


    }

    override fun onProviderDisabled(p0: String?) {


    }

    override fun onProviderEnabled(p0: String?) {


    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {



    }

    private fun requestPermission() {

        ActivityCompat.requestPermissions(activity as AppCompatActivity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),10)

    }

    override fun getContentView(): Int {

        return R.layout.fragment_home_map

    }




}