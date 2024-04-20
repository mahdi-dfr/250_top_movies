package com.example.filmnegar.utils

sealed class MyScreens(val rout: String){
    object HomeScreen: MyScreens("home")
    object SearchScreen: MyScreens("search")
    object DashboardScreen: MyScreens("dashboard")
    object MovieScreen: MyScreens("movie")
    object AllMoviesScreen: MyScreens("all_movie")
}
