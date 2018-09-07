package com.example.tilman.samba_demo.mvp.home.profile

import android.os.Bundle
import android.util.Log
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.Samba
import com.example.tilman.samba_demo.mvp.base.BaseFragment
import javax.inject.Inject

class HomeFragmentProfile : BaseFragment(), ProfileContract.ProfileView {

    @Inject lateinit var presenter: ProfileContract.ProfilePresenter

    val app = Samba.getApplication()


    companion object {

        fun newInstance(): HomeFragmentProfile {

            val fragment = HomeFragmentProfile()

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

        Log.d("BTM_NAV_BAR", "Profile Reselected")

    }


    override fun getContentView(): Int {

        return R.layout.fragment_home_profile

    }


}