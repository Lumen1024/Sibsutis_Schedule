package com.example.sibsutisschedule.screens.welcome

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sibsutisschedule.data.ScheduleRepository
import com.example.sibsutisschedule.data.group.Group
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : ViewModel() {
    private val _state = MutableStateFlow(WelcomeState())
    val state = _state.asStateFlow()

    private fun updateGroups() {
        var newGroups = emptyList<Group>()
        try {
            viewModelScope.launch {
                newGroups = scheduleRepository.getGroups(_state.value.groupName)
            }
        } catch (e: Exception) {
            Log.w("groups", e.stackTraceToString())
        }
        _state.value = _state.value.copy(groups = newGroups)
    }

    fun onGroupNameChanged(groupName: String) {
        _state.value = _state.value.copy(groupName = groupName)
        updateGroups()
    }

    fun onGroupSelected() {
        // todo: save group name to shared pref
    }
}