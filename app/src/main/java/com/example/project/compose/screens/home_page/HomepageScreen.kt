package com.example.project.compose.screens.home_page

import android.app.Activity
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.project.R
import com.example.project.auth.UserData
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.project.viewmodels.SharedViewModel
import com.example.project.compose.screens.connection.ConnectionErrorComponent
import com.example.project.compose.widgets.about_college.AboutCollegeWidget
import com.example.project.compose.widgets.headers.AnimatedHeaderWidget
import com.example.project.compose.widgets.info_about_college.InformationAboutCollegeWidget
import com.example.project.compose.widgets.links.AdminLinksWidget
import com.example.project.compose.widgets.schedule.ScheduleSelectButtonWidget
import com.example.project.compose.widgets.slider.PhotoSliderWidget
import com.example.project.viewmodels.NewsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomepageScreen(
    navController: NavHostController,
    newsViewModel: NewsViewModel,
    userData: UserData?,
    viewModel: SharedViewModel,
) {

    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        if (newsViewModel.errorMessage.isBlank()) {
            newsViewModel.getNews()
        }
    }

    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState()

    val context = LocalContext.current as OnBackPressedDispatcherOwner

    DisposableEffect(context) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (pagerState.currentPage != 0) {

                } else {
                    (context as? Activity)?.finish()
                }
            }
        }

        context.onBackPressedDispatcher.addCallback(callback)

        onDispose {
            callback.remove()
        }
    }

    if (newsViewModel.errorMessage.isBlank()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            AboutCollegeWidget(navController = navController)

            PhotoSliderWidget(navController = navController, newsList = newsViewModel.newsList, pagerState = pagerState)

            ScheduleSelectButtonWidget(
                navController = navController,
                viewModel = viewModel
            )

            AdminLinksWidget()

            InformationAboutCollegeWidget(context = LocalContext.current)

            Spacer(modifier = Modifier.padding(25.dp))
        }

        AnimatedHeaderWidget(
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            text = stringResource(R.string.main_page),
            scrollState = scrollState,
            navController = navController,
            userData = userData
        )
    }
    else {
        ConnectionErrorComponent {
            if (newsViewModel.isConnected()) {
                isRefreshing = true
                newsViewModel.fetchData()
            }
        }
    }
}