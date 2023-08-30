package com.example.sibsutisschedule.data

import com.example.sibsutisschedule.data.group.GroupsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ScheduleServices {
    @GET("ajax/get_groups.php")
    fun getGroupList(@Query("search_group") searchGroup: String) : Call<GroupsResponse>

    // todo : get page with schedule logic
}