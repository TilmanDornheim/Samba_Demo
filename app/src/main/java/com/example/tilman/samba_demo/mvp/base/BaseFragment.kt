package com.example.tilman.samba_demo.mvp.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import com.example.tilman.samba_demo.mvp.base.BaseContract.BaseView

abstract class BaseFragment : Fragment(), BaseView {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(getContentView(), container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButterKnife.bind(this, view)

    }


    abstract fun getContentView(): Int

    override fun showToast(text: String) {

        Toast.makeText(activity,text,Toast.LENGTH_SHORT).show()

    }


}

