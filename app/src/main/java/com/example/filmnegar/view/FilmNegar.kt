package com.example.filmnegar.view

import HomeScreen
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.filmnegar.utils.BottomNavItem
import com.example.filmnegar.utils.MyScreens
import com.example.filmnegar.view.features.search.SearchScreen
import com.example.filmnegar.view.theme.customPrimaryColor

@Composable
fun FilmNegar() {

    val navController = rememberNavController()

    Scaffold(topBar = {
        TopAppBar(backgroundColor = customPrimaryColor) {
        }
    },
        bottomBar = {
            CustomNavigationBar(navController)
        }) {


        NavHost(
            navController = navController,
            startDestination = MyScreens.HomeScreen.rout,){

            composable(MyScreens.HomeScreen.rout){
                HomeScreen()
            }

            composable(MyScreens.SearchScreen.rout){
                SearchScreen()
            }

            composable(MyScreens.DashboardScreen.rout){
                DashboardScreen()
            }
        }

    }

}


@Composable
fun CustomNavigationBar(navController: NavController) {
    val navItems = listOf<BottomNavItem>(
        BottomNavItem(
            title = "نگارخانه",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home,
            route = MyScreens.HomeScreen.rout
        ),

        BottomNavItem(
            title = "جستجو",
            selectedIcon = Icons.Filled.Search,
            unSelectedIcon = Icons.Outlined.Search,
            route = MyScreens.SearchScreen.rout
        ),

        BottomNavItem(
            title = "نگارخانه ی من",
            selectedIcon = Icons.Filled.Person,
            unSelectedIcon = Icons.Outlined.Person,
            route = MyScreens.DashboardScreen.rout
        ),
    )

    var selectedNavItemIndex by rememberSaveable {
        mutableStateOf(0)

    }

    NavigationBar(containerColor = customPrimaryColor) {
        navItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = selectedNavItemIndex == index,
                onClick = {
                    selectedNavItemIndex = index
                    navController.navigate(bottomNavItem.route)

                }, icon = {
                    if (selectedNavItemIndex == index) {
                        bottomNavItem.selectedIcon
                    } else {
                        bottomNavItem.unSelectedIcon
                    }
                },
                label = {
                    Text(text = bottomNavItem.title)
                })
        }

    }
}