package com.example.project.compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.project.R
import com.example.project.viewmodels.PhotoViewModel

@Composable
fun TestScreen(
    viewModel: PhotoViewModel
) {
    var query by remember { mutableStateOf("") }
    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        if (viewModel.errorMessage.isBlank()) {
            viewModel.getPhoto()
        }
    }

    Scaffold { paddingValues ->
        if (viewModel.errorMessage.isBlank()) {
            Column(modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
            ) {
                TextField(
                    value = query,
                    onValueChange = {
                        query = it
                        viewModel.filterPhotosByPhotographer(it)
                    },
                    label = { Text("Search") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                )
                LazyColumn(content = {
                    items(viewModel.filteredPhotoList) { photo ->
                        AsyncImage(
                            model = photo.src.original,
                            contentDescription = photo.photographer,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp))
                                .clickable {
                                    // Handle click on image
                                }
                                .padding(top = 2.5.dp, bottom = 2.5.dp)
                        )
                    }
                })
            }
        } else {
            ConnectionErrorComponent {
                if (viewModel.isConnected()) {
                    isRefreshing = true
                    viewModel.fetchData()
                }
            }
        }
    }
}


@Composable
fun ConnectionErrorComponent(onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "No internet connection",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = onRetry,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(Icons.Default.Refresh, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Retry")
        }
    }
}
