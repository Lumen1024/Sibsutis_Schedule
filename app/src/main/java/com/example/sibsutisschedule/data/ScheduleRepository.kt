package com.example.sibsutisschedule.data

import com.example.sibsutisschedule.data.group.Group
import com.example.sibsutisschedule.data.schedule.ScheduleBlock

class ScheduleRepository(
    private val service: ScheduleServices
) {
    suspend fun getGroups(groupName: String): List<Group> {
        val response = service.getGroupList(groupName).execute()
        return response.body()?.results ?: emptyList()
    }

    suspend fun getScheduleBlock(groupName: String) : List<ScheduleBlock> {
        return emptyList() // todo : get ScheduleBlock logic
    }
}