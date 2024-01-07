package com.example.project.compose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.R
import com.example.project.compose.widgets.StaticHeaderWidget
import com.example.project.data.contacts.Contacts
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import java.util.UUID

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactsPageScreen(
    onBackClick: () -> Unit
) {

    val uuid = UUID.randomUUID()
    val scrollState = rememberScrollState()

    val contactsListKazinca = listOf(
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.priemnaya),
            name = stringResource(id = R.string.priemnaya_name),
            telephone = stringResource(id = R.string.priemnaya_telephone)
        ),
    )

    Scaffold(
        content = {
            Column {
                StaticHeaderWidget(
                    text = stringResource(id = R.string.link_contacts),
                    imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                    onBackClick = {
                        onBackClick()
                    }
                )
                
                Text(text = stringResource(id = R.string.kazinca), modifier = Modifier.align(Alignment.CenterHorizontally))

                LazyColumn(content = {
                    items(contactsListKazinca) {
                        Row {
                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                    .weight(1f)
                                    .fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = it.position,
                                    fontFamily = Roboto,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                    .weight(1f)
                                    .fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = it.name,
                                    fontFamily = Roboto,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                    .weight(1f)
                                    .fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = it.telephone,
                                    fontFamily = Roboto,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight(500),
                                    color = Color(PrimaryBlue.toArgb()),
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                })
            }
        }
    )
}