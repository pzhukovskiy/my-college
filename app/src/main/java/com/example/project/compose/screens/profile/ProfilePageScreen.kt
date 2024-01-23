package com.example.project.compose.screens.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.auth.UserData
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.data.database.GroupDatabase
import com.example.project.data.database.GroupEvent
import com.example.project.data.database.GroupState
import com.example.project.data.database.dao.GroupDAO
import com.example.project.navigation.NavigationItem
import com.example.project.repository.group.GroupsRepositoryImplementation
import com.example.project.repository.teachers.TeacherRepositoryImplementation
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import com.example.project.viewmodels.GroupsViewModel
import com.example.project.viewmodels.SharedViewModel

@Composable
fun ProfilePageScreen(
    userData: UserData?,
    onSignOut: () -> Unit,
    onBackClick: () -> Unit,
    navController: NavController,
    db: GroupDatabase,
    onEvent: (GroupEvent) -> Unit,
    state: GroupState,
    viewModel: SharedViewModel,
) {

    val groupValue = viewModel.groupValue.value

    var expandedGroup by remember { mutableStateOf(false) }
    var selectedItemGroup by remember { mutableStateOf("") }
    var selectedIndexGroup by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val visibleItemsGroup = 5

    val iconGroup = if (expandedGroup) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    val groupViewModel = GroupsViewModel(GroupsRepositoryImplementation(), LocalContext.current, db.dao)
    val viewModel = SharedViewModel()

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        if (groupViewModel.errorMessage.isBlank()) {
            groupViewModel.getGroups()
        }
    }

    Column(
        Modifier.fillMaxHeight()
    ) {
        StaticHeaderWidget(
            text = stringResource(id = R.string.profile),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = onBackClick
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Column {
                if (userData?.profilePictureUrl != null && userData?.username != null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                            .height(50.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box {
                                AsyncImage(
                                    model = userData.profilePictureUrl,
                                    contentDescription = stringResource(id = R.string.profile),
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )

                                Text(
                                    text = userData.username,
                                    fontFamily = Roboto,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight(700),
                                    style = MaterialTheme.typography.body1,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(start = 40.dp, top = 3.dp)
                                )
                            }

                            Row(
                                modifier = Modifier.padding(end = 4.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clickable {
                                            if (userData.userId !in AccessAccountsList) {
                                                Toast
                                                    .makeText(
                                                        context,
                                                        "Недостаточно прав",
                                                        Toast.LENGTH_LONG
                                                    )
                                                    .show()
                                            } else {
                                                navController.navigate(NavigationItem.AdministratorWebView.route)
                                            }
                                        }
                                )
                                Icon(
                                    imageVector = Icons.Default.ExitToApp,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clickable {
                                            onSignOut()
                                        }
                                )
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "Выбрать сохраненную группу",
                        fontFamily = Roboto,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(700),
                        style = MaterialTheme.typography.body2
                    )
                }

                Box(
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Column {
                        OutlinedTextField(
                            value = selectedItemGroup,
                            onValueChange = { selectedItemGroup = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    textFieldSize = coordinates.size.toSize()
                                },
                            readOnly = true,
                            label = { Text(text = stringResource(id = R.string.select_group))},
                            trailingIcon = {
                                Icon(
                                    imageVector = iconGroup,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .clickable {
                                            expandedGroup = !expandedGroup
                                        }
                                )
                            }
                        )

                        DropdownMenu(
                            expanded = expandedGroup,
                            onDismissRequest = { expandedGroup = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                                .verticalScroll(rememberScrollState())
                                .heightIn(max = with(LocalDensity.current) { 48.dp * visibleItemsGroup })
                        ) {
                            groupViewModel.groupList.forEach { group ->
                                DropdownMenuItem(onClick = {
                                    selectedIndexGroup = group.id.toString()
                                    selectedItemGroup = group.group
                                    expandedGroup = false
                                }) {
                                    Text(text = "${group.group}")
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth()
                                .background(Color(PrimaryBlue.toArgb()))
                                .height(40.dp)
                                .clickable {
                                    onEvent(GroupEvent.SetGroupName(selectedItemGroup))
                                    onEvent(GroupEvent.SetGroupId(selectedIndexGroup.toInt()))
                                    onEvent(GroupEvent.SaveGroup)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Сохранить",
                                fontFamily = Roboto,
                                color = Color.White,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(500),
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    LazyColumn(content = {
                        items(state.groups) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ) {
                                Row {
                                    Text(text = it.Name)
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clickable {
                                                onEvent(GroupEvent.DeleteItem(it))
                                            }
                                    )
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}