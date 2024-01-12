package com.example.project.compose.widgets.schedule

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.project.R
import com.example.project.navigation.NavigationItem
import com.example.project.repository.group.GroupsRepositoryImplementation
import com.example.project.repository.teachers.TeacherRepositoryImplementation
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import com.example.project.viewmodels.GroupsViewModel
import com.example.project.viewmodels.TeacherViewModel

@Composable
fun ScheduleSelectButtonWidget(
    navController: NavHostController
) {

    var expandedGroup by remember { mutableStateOf(false) }
    var selectedItemGroup by remember { mutableStateOf("") }

    var expandedTeacher by remember { mutableStateOf(false) }
    var selectedItemTeacher by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val visibleItemsGroup = 5
    val visibleItemsTeacher = 5

    val iconGroup = if (expandedGroup) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    val iconTeacher = if (expandedTeacher) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    val groupViewModel = GroupsViewModel(GroupsRepositoryImplementation(), LocalContext.current)
    val teacherViewModel = TeacherViewModel(TeacherRepositoryImplementation(), LocalContext.current)

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        if (groupViewModel.errorMessage.isBlank()) {
            groupViewModel.getGroups()
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
            text = stringResource(id = R.string.link_schedule),
            fontFamily = Roboto,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight(700),
            style = MaterialTheme.typography.body2
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(330.dp)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Column {
            Box(
                modifier = Modifier.height(160.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                    ) {
                        OutlinedTextField(
                            value = selectedItemGroup,
                            onValueChange = { selectedItemGroup = it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    textFieldSize = coordinates.size.toSize()
                                },
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
                                    selectedItemGroup = group.group
                                    expandedGroup = false
                                }) {
                                    Text(text = group.group)
                                }
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
                                if (selectedItemGroup == "") {
                                    Toast
                                        .makeText(
                                            context,
                                            context.getString(R.string.select_group),
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                } else {
                                    navController.navigate(NavigationItem.LessonsScreen.route)
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.link_schedule_day),
                            fontFamily = Roboto,
                            color = Color.White,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(500),
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth()
                            .background(Color(PrimaryBlue.toArgb()))
                            .height(40.dp)
                            .clickable {
                                if (selectedItemGroup == "") {
                                    Toast
                                        .makeText(
                                            context,
                                            context.getString(R.string.select_group),
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                }
                                else {

                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.link_schedule_week),
                            fontFamily = Roboto,
                            color = Color.White,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(500),
                        )
                    }
                }
            }

            Box(
                modifier = Modifier.height(160.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                    ) {
                        OutlinedTextField(
                            value = selectedItemTeacher,
                            onValueChange = { selectedItemTeacher = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    textFieldSize = coordinates.size.toSize()
                                },
                            label = { Text(text = stringResource(id = R.string.select_teacher))},
                            trailingIcon = {
                                Icon(
                                    imageVector = iconTeacher,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .clickable {
                                            expandedTeacher = !expandedTeacher
                                        }
                                )
                            }
                        )

                        DropdownMenu(
                            expanded = expandedTeacher,
                            onDismissRequest = { expandedTeacher = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                                .verticalScroll(rememberScrollState())
                                .heightIn(max = with(LocalDensity.current) { 48.dp * visibleItemsTeacher })
                        ) {
                            teacherViewModel.teachersList.forEach { teacher ->
                                DropdownMenuItem(onClick = {
                                    selectedItemTeacher = "${teacher.middle_name} ${teacher.first_name[0]}. ${teacher.last_name[0]}."
                                    expandedTeacher = false
                                }) {
                                    Text(text = "${teacher.middle_name} ${teacher.first_name[0]}. ${teacher.last_name[0]}.")
                                }
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
                                if (selectedItemTeacher == "") {
                                    Toast
                                        .makeText(
                                            context,
                                            context.getString(R.string.select_teacher),
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                }
                                else {

                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.link_schedule_day),
                            fontFamily = Roboto,
                            color = Color.White,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(500),
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth()
                            .background(Color(PrimaryBlue.toArgb()))
                            .height(40.dp)
                            .clickable {
                                if (selectedItemTeacher == "") {
                                    Toast
                                        .makeText(
                                            context,
                                            context.getString(R.string.select_teacher),
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                }
                                else {

                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.link_schedule_week),
                            fontFamily = Roboto,
                            color = Color.White,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(500),
                        )
                    }
                }
            }
        }
    }
}