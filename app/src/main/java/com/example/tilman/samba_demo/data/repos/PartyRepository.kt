package com.example.tilman.samba_demo.data.repos

import com.example.tilman.samba_demo.data.api.MockApi
import com.example.tilman.samba_demo.data.models.Party
import io.reactivex.Observable
import javax.inject.Inject

class PartyRepository

constructor(private val mockApiService: MockApi){

    val mockPartyList = ArrayList<Party>()




    fun getParties(): Observable<ArrayList<Party>>{

        // This is where later on we will use the Retrofit Service that is injected.

        // For now we will return a simple list of parties we create right here

        // However, to show that it would be a simple step to retrieve data from an existing remote source,
        // all dependencies are already provided

        setUpMockParties()

        return Observable.just(mockPartyList)


    }

    private fun setUpMockParties() {

        mockPartyList.add(Party(1, "Tommaso's Party"))
        mockPartyList.add(Party(2, "Kanye West @ Complex"))
        mockPartyList.add(Party(3,"Late-night Get together"))
        mockPartyList.add(Party(4, "Michael's Party"))

    }


}