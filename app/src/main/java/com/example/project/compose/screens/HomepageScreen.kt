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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberUpdatedState
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
import com.example.project.data.news.NewsInfo
import androidx.activity.OnBackPressedDispatcherOwner

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomepageScreen(
    navController: NavHostController,
    newsList: List<NewsInfo>,
    userData: UserData?
) {

    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState()

    val context = LocalContext.current as OnBackPressedDispatcherOwner

    DisposableEffect(context) {
        // Registering onBackPressed callback
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Handle the back button press
                if (pagerState.currentPage != 0) {

                } else {
                    // If on the first page, close the app
                    (context as? Activity)?.finish()
                }
            }
        }

        // Add the callback to the dispatcher
        context.onBackPressedDispatcher.addCallback(callback)

        onDispose {
            // Remove the callback when the composable is disposed
            callback.remove()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        PhotoSliderWidget(navController = navController, newsList = newsList, pagerState = pagerState)

        ScheduleSelectButtonWidget()

//        Text(
//            text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
//            modifier = Modifier.padding(12.dp),
//            style = MaterialTheme.typography.h6
//        )
//
//        Text(
//            text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
//            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
//            style = MaterialTheme.typography.body1
//        )

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