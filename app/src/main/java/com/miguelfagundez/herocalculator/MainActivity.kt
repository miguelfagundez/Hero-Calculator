package com.miguelfagundez.herocalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miguelfagundez.herocalculator.events.CalculatorEvents
import com.miguelfagundez.herocalculator.events.CalculatorOperation
import com.miguelfagundez.herocalculator.state.CalculatorViewModel
import com.miguelfagundez.herocalculator.ui.components.CalculatorBox
import com.miguelfagundez.herocalculator.ui.components.CalculatorButton
import com.miguelfagundez.herocalculator.ui.drawer.CalculatorDrawer
import com.miguelfagundez.herocalculator.ui.drawer.NavigationItem
import com.miguelfagundez.herocalculator.ui.theme.HeroCalculatorTheme
import com.miguelfagundez.herocalculator.ui.theme.LightGray
import com.miguelfagundez.herocalculator.ui.theme.MediumGray
import com.miguelfagundez.herocalculator.ui.theme.Orange
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = CalculatorDrawer.navigationItems

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val drawerItems = CalculatorDrawer.navigationItems

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                ModalNavigationDrawer(
                    drawerContent = {
                                    ModalDrawerSheet {
                                        Spacer(modifier = Modifier.height(16.dp))
                                        drawerItems.forEachIndexed { index, item ->
                                            NavigationDrawerItem(
                                                label = {
                                                        Text(text = item.title)
                                                },
                                                selected = index == selectedItemIndex,
                                                onClick = {
                                                    selectedItemIndex = index
                                                    scope.launch {
                                                        drawerState.close()
                                                    }
                                                },
                                                icon = {
                                                    Icon(
                                                        imageVector = if (index == selectedItemIndex){
                                                                         item.selectedIcon
                                                                     } else item.unselectedIcon,
                                                        contentDescription = item.title
                                                    )
                                                },
                                                modifier = Modifier
                                                    .padding(NavigationDrawerItemDefaults.ItemPadding)
                                            )
                                        }
                                    }
                    },
                    drawerState = drawerState
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Hero Calculator")
                                },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Menu"
                                        )
                                    }
                                }
                            )
                        }
                    ) {
                    }
                }
            }
//            HeroCalculatorTheme {
//                // A surface container using the 'background' color from the theme
//                val viewModel = viewModel<CalculatorViewModel>()
//                val state = viewModel.state
//                // Spacing between buttons
//                val spacing = 8.dp
//
//                // Calculator view
//                CalculatorBox(
//                    state = state,
//                    action = viewModel::action,
//                    btnSpacing = spacing,
//                    info = Modifier
//                        .fillMaxSize()
//                        .background(MediumGray)
//                        .padding(16.dp)
//                )
//            }
        }
    }
}