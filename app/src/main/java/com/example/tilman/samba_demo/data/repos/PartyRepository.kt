package com.example.tilman.samba_demo.data.repos

import com.example.tilman.samba_demo.data.api.MockApi
import com.example.tilman.samba_demo.data.models.Party
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class PartyRepository

constructor(private val mockApiService: MockApi){

    val mockPartyList = ArrayList<Party>()




    fun getParties(): Single<ArrayList<Party>> {

        // This is where later on we will use the Retrofit Service that is injected.

        // For now we will return a simple list of parties we create right here

        // However, to show that it would be a simple step to retrieve data from an existing remote source,
        // all dependencies are already provided

        setUpMockParties()

        return Single.just(mockPartyList)


    }

    private fun setUpMockParties() {

        mockPartyList.clear()

        val calendar = Calendar.getInstance()

        val dateNow = calendar.time

        calendar.add(Calendar.DATE, 3)

        val dateThisWeek = calendar.time

        calendar.add(Calendar.DATE,4)

        val dateNextWeek = calendar.time


        mockPartyList.add(Party(1, "Tommaso's Party", dateNow))
        mockPartyList.add(Party(2, "Kanye West @ Complex", dateNow))
        mockPartyList.add(Party(3,"Late-night Get together", dateNextWeek))
        mockPartyList.add(Party(4, "Michael's Party", dateThisWeek))
        mockPartyList.add(Party(5, "Antii Release Party", dateThisWeek))
        mockPartyList.add(Party(6, "Maybritt's Birthday", dateNextWeek))

    }


}