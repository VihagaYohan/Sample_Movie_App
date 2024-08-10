package com.techtribeservices.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techtribeservices.movieapp.screens.details.DetailsScreen
import com.techtribeservices.movieapp.screens.home.HomeScreen

// nav controller
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        // build nav graph
        composable(route = MovieScreens.HomeScreen.name) {
            // here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        // www.google.com/details-screen/id=34
        composable(route = MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name="movie"){type = NavType.StringType})
        ) {
            backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie"))
        }
    }
}