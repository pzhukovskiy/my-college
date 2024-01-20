package com.example.project.compose.screens.links

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.data.links.Links
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.Roboto
import java.util.UUID

@Composable
fun ListAllLinksScreen(
    context: Context,
    navController: NavController,
    onBackClick: () -> Unit
) {

    val uuid = UUID.randomUUID()

    val listAllLinks = listOf(
        Links(id = uuid.toString(), text = context.getString(R.string.link_college_administration),  route = NavigationItem.ListAdministration.route),
        Links(id = uuid.toString(), text = context.getString(R.string.link_college_teachers),  route = NavigationItem.ListTeachers.route),
        Links(id = uuid.toString(), text = context.getString(R.string.link_employee),  route = NavigationItem.ListEmployees.route),
        Links(id = uuid.toString(), text = context.getString(R.string.link_employee_ahch),  route = NavigationItem.ListEmployeesAHCH.route),
        Links(id = uuid.toString(), text = context.getString(R.string.link_contacts),  route = NavigationItem.ContactsPage.route),
        Links(id = uuid.toString(), text = context.getString(R.string.link_calls),  route = NavigationItem.ScheduleTime.route)
    )

    Scaffold(
        content = {
            Column {
                StaticHeaderWidget(
                    text = stringResource(id = R.string.links),
                    imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                    onBackClick = {
                        onBackClick()
                    }
                )

                LazyColumn(content = {
                    items(listAllLinks) { link ->
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .clickable {
                                       navController.navigate(link.route)
                                },
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Box(
                                contentAlignment = Alignment.CenterEnd,
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)
                            ) {
                                IconButton(onClick = { navController.navigate(link.route) }) {
                                    Icon(
                                        Icons.Default.ArrowForward,
                                        contentDescription = "Forward",
                                        tint = Color.Black
                                    )
                                }
                                Text(
                                    text = link.text,
                                    style = MaterialTheme.typography.body2,
                                    color = Color.Black,
                                    fontFamily = Roboto,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight(500),
                                    modifier = Modifier
                                        .align(Alignment.CenterStart)
                                        .padding(it)
                                )
                            }
                        }
                    }
                })
            }
        }
    )

}