package com.example.tilman.samba_demo.data.repos

import com.example.tilman.samba_demo.data.api.MockApi
import com.example.tilman.samba_demo.data.models.Party
import io.reactivex.Single
import java.util.*
import kotlin.collections.ArrayList

class PartyRepository

constructor(private val mockApiService: MockApi){

    val mockAttendingPartyList = ArrayList<Party>()

    val mockHostingPartyList = ArrayList<Party>()




    fun getAttendingParties(): Single<ArrayList<Party>> {

        // This is where later on we will use the Retrofit Service that is injected.

        // For now we will return a simple list of parties we create right here

        // However, to show that it would be a simple step to retrieve data from an existing remote source,
        // all dependencies are already provided

        setUpMockAttendingParties()

        return Single.just(mockAttendingPartyList)


    }

    fun getHostingParties(): Single<ArrayList<Party>> {

        // Same as above

        setUpMockHostingParties()

        return Single.just(mockHostingPartyList)


    }

    private fun setUpMockAttendingParties() {

        mockAttendingPartyList.clear()

        val calendar = Calendar.getInstance()

        val dateNow = calendar.time

        calendar.add(Calendar.DATE, 3)

        val dateThisWeek = calendar.time

        calendar.add(Calendar.DATE,4)

        val dateNextWeek = calendar.time


        mockAttendingPartyList.add(Party(1, "Tommaso's Party", dateNow))
        mockAttendingPartyList.add(Party(2, "Kanye West @ Complex", dateNow))
        mockAttendingPartyList.add(Party(3,"Late-night Get together", dateNextWeek))
        mockAttendingPartyList.add(Party(4, "Michael's Party", dateThisWeek))
        mockAttendingPartyList.add(Party(5, "Antii Release Party", dateThisWeek))
        mockAttendingPartyList.add(Party(6, "Maybritt's Birthday", dateNextWeek))

    }

    private fun setUpMockHostingParties(){

        mockHostingPartyList.clear()

        val calendar = Calendar.getInstance()

        calendar.add(Calendar.DATE,10)

        val date = calendar.time

        mockHostingPartyList.add(Party(11,"Birthday Banger", date))

    }


}