package pe.edu.upc.easyvet.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource


@Composable
fun Main() {

    var selectedTab by rememberSaveable {
        mutableStateOf(MainTab.Home)
    }

    Scaffold(bottomBar = {
        NavigationBar {
            MainTab.entries.forEach { tab ->
                NavigationBarItem(
                    selected = selectedTab == tab ,
                    onClick = {
                        selectedTab = tab
                    },
                    icon = {
                        Icon(painterResource(tab.resourceId), contentDescription = tab.label)
                    },
                    label = {
                        Text(text = tab.label)
                    }
                )
            }
        }
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            when (selectedTab) {
                MainTab.Home -> HomeNavHost()
                else -> Text(text = selectedTab.label)
            }
        }

    }
}



