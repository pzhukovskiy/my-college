package com.example.project

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.project.auth.GoogleAuthUiClient
import com.example.project.auth.SignInViewModel
import com.example.project.compose.screens.DetailNewsScreen
import com.example.project.compose.screens.HomepageScreen
import com.example.project.compose.screens.ListAllLinksScreen
import com.example.project.compose.screens.ProfilePageScreen
import com.example.project.compose.screens.SettingsPageScreen
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.ProjectTheme
import com.example.project.utilities.parseListNews
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {

            //notifications
            val notificationChannel= NotificationChannel(
                "project_notification",
                "Project",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
            //

            val navController: NavHostController = rememberNavController()
            val newsList = parseListNews(LocalContext.current, "simpleView.news")

            ProjectTheme {
                NavHost(
                    navController = navController,
                    startDestination = NavigationItem.Homepage.route
                ) {

                    //homepage
                    composable(NavigationItem.Homepage.route) {
                            HomepageScreen(
                                navController = navController,
                                newsList = newsList,
                            )
                    }

                    //information about news
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

                    //list all links
                    composable(NavigationItem.ListAllLinks.route) {
                        ListAllLinksScreen(onBackClick = {
                            navController.popBackStack()
                        })
                    }

                    //settings page with auth
                    composable(NavigationItem.SettingsPage.route) {
                        val viewModel = viewModel<SignInViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        LaunchedEffect(key1 = Unit) {
                            if (googleAuthUiClient.getSignedInUser() != null) {
                                navController.navigate(NavigationItem.Profile.route)
                            }
                        }

                        val launcher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.StartIntentSenderForResult(),
                            onResult = { result ->
                                if (result.resultCode == RESULT_OK) {
                                    lifecycleScope.launch {
                                        val signInResult = googleAuthUiClient.signInWithIntent(
                                            intent = result.data ?: return@launch
                                        )
                                        viewModel.onSignInResult(signInResult)
                                    }
                                }
                            }
                        )

                        LaunchedEffect(key1 = state.isSignInSuccessful) {
                            if (state.isSignInSuccessful) {
                                Toast.makeText(applicationContext, "Успешный вход", Toast.LENGTH_LONG).show()
                                navController.navigate(NavigationItem.Profile.route)
                                viewModel.resetState()
                            }
                        }

                        SettingsPageScreen(
                            state = state,
                            onSignInClick = {
                                lifecycleScope.launch {
                                    val signInIntentSender = googleAuthUiClient.signIn()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            }
                        )
                    }

                    //profile
                    composable(NavigationItem.Profile.route) {
                        ProfilePageScreen(
                            userData = googleAuthUiClient.getSignedInUser(),
                            onSignOut = {
                                lifecycleScope.launch {
                                    googleAuthUiClient.signOut()
                                    Toast.makeText(applicationContext, "Успешно вышли", Toast.LENGTH_LONG).show()

                                    navController.popBackStack()
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}