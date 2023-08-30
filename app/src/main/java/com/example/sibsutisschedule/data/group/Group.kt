package com.example.sibsutisschedule.data.group

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

// todo : room annotation
data class Group (
    @SerializedName("id")
    val id : Long,
    @SerializedName("text")
    val name: String
)