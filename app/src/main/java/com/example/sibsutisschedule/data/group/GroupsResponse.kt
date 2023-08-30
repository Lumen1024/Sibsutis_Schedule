package com.example.sibsutisschedule.data.group

import com.google.gson.annotations.SerializedName

data class GroupsResponse(
    @SerializedName("results")
    var results: List<Group>?
)