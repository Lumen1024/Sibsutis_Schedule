package com.example.sibsutisschedule.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sibsutisschedule.data.group.Group

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    state: WelcomeState,
    onEvent: (WelcomeEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ) { paddingValues ->
        val e = paddingValues
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp, 32.dp, 32.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Выберите свою группу", fontSize = 20.sp)
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                value = state.groupName,
                onValueChange = { onEvent(WelcomeEvent.GroupNameChanged(it)) }
            )
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                items(state.groups) {
                    GroupItem(onEvent, group = it)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun GroupItem(
    onEvent: (WelcomeEvent) -> Unit,
    group: Group
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onEvent(WelcomeEvent.GroupSelected(group))
        }
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.AccountBox, contentDescription = "null")
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = group.name.uppercase(),
                fontSize = 15.sp
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    val state = WelcomeState().copy(
        groupName = "ип-",
        groups = (1..50).map {
            Group(id = (100 + it).toLong(), name = "ип-216")
        }
    )
    WelcomeScreen(state = state, onEvent = {})
}