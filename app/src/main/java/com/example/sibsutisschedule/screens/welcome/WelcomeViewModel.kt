package com.example.sibsutisschedule.screens.welcome

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.sibsutisschedule.data.group.Group
import com.example.sibsutisschedule.data.ScheduleRepository
import com.example.sibsutisschedule.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : ViewModel() {

    var navHostController: NavHostController? = null

    private val _state = MutableStateFlow(WelcomeState())
    val state = _state.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {
            state.debounce(150L).collect() {
                updateGroups(it.groupName)
            }
        }
    }

    private suspend fun updateGroups(groupName: String) {
        var newGroups = emptyList<Group>()
        try {
            newGroups = scheduleRepository.getGroups(groupName)
        } catch (e: Exception) {
            Log.w("groups", e.stackTraceToString())
        }
        _state.value = _state.value.copy(groups = newGroups)
    }

    private fun onGroupNameChanged(groupName: String) {
        _state.value = _state.value.copy(groupName = groupName)
    }

    private fun onGroupSelected(group: Group) {
        navHostController?.navigate(Screen.Schedule.route)
    }

    fun onEvent(event: WelcomeEvent) {
        when (event) {
            is WelcomeEvent.GroupNameChanged -> onGroupNameChanged(event.groupName)
            is WelcomeEvent.GroupSelected -> onGroupSelected(event.group)
        }
    }
}