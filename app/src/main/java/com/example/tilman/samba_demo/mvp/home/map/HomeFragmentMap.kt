package com.example.tilman.samba_demo.mvp.home.map

import android.os.Bundle
import android.util.Log
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import javax.inject.Inject

class HomeFragmentMap : BaseFragment(), MapContract.MapView {

    @Inject
    lateinit var presenter: MapContract.MapPresenter

    val app = Samba.getApplication()

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

    override fun onDestroy() {

        super.onDestroy()

        presenter.onDetach()

        app.releaseNavigationFragmentComponent()
    }


    override fun reselected() {

        Log.d("BTM_NAV_BAR", "Map Reselected")

    }

    override fun getContentView(): Int {

        return R.layout.fragment_home_map

    }


}