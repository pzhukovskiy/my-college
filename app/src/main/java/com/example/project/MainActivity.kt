package com.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.project.compose.screens.DetailNewsScreen
import com.example.project.compose.screens.HomepageScreen
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.ProjectTheme
import com.example.project.utilities.parseListNews

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {

            val navController: NavHostController = rememberNavController()
            val newsList = parseListNews(LocalContext.current, "simpleView.news")

            ProjectTheme {
                NavHost(
                    navController = navController,
                    startDestination = NavigationItem.Homepage.route
                ) {
                    composable(NavigationItem.Homepage.route) {
                            HomepageScreen(
                                navController = navController,
                                newsList = newsList,
                            )
                    }

                    composable("${NavigationItem.DetailNews.route}/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val itemID = backStackEntry.arguments?.getInt("id")
                        val selectedItem = newsList.find { it.pk == itemID }
                        selectedItem?.let {
                            DetailNewsScreen(
                                news = it,
                                context = LocalContext.current,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}