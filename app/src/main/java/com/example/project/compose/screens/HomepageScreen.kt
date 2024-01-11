package com.example.project.compose.screens

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
import com.example.project.compose.widgets.AdminLinksWidget
import com.example.project.compose.widgets.AnimatedHeaderWidget
import com.example.project.compose.widgets.BottomBarCustomWidget
import com.example.project.compose.widgets.InformationAboutCollegeWidget
import com.example.project.compose.widgets.PhotoSliderWidget
import com.example.project.compose.widgets.ScheduleSelectButtonWidget
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.project.compose.widgets.AboutCollegeWidget
import com.example.project.repository.GroupsRepositoryImplementation
import com.example.project.viewmodels.GroupsViewModel
import com.example.project.viewmodels.NewsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomepageScreen(
    navController: NavHostController,
    viewModel: NewsViewModel,
    userData: UserData?
) {

    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        if (viewModel.errorMessage.isBlank()) {
            viewModel.getNews()
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

    if (viewModel.errorMessage.isBlank()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            AboutCollegeWidget(navController = navController)

            PhotoSliderWidget(navController = navController, newsList = viewModel.newsList, pagerState = pagerState)

            ScheduleSelectButtonWidget(
                navController = navController
            )

            AdminLinksWidget()

            InformationAboutCollegeWidget(context = LocalContext.current)

            BottomBarCustomWidget(navController = navController, userData = userData)

            Spacer(modifier = Modifier.padding(25.dp))
        }

        AnimatedHeaderWidget(
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            text = stringResource(R.string.main_page),
            scrollState = scrollState
        )
    }
    else {
        ConnectionErrorComponent {
            if (viewModel.isConnected()) {
                isRefreshing = true
                viewModel.fetchData()
            }
        }
    }
}