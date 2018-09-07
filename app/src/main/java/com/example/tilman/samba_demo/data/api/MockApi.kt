package com.example.tilman.samba_demo.data.api

import com.example.tilman.samba_demo.data.models.Party
import io.reactivex.Observable
import retrofit2.http.GET

interface MockApi{

    @GET("/NotUsedForNow")
    fun getParties(): Observable<ArrayList<Party>>


}