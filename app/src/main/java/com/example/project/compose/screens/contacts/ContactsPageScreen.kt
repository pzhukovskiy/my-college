package com.example.project.compose.screens.contacts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.data.contacts.Contacts
import com.example.project.ui.theme.Roboto
import java.util.UUID

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
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        StaticHeaderWidget(
            text = stringResource(id = R.string.link_contacts),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = {
                onBackClick()
            }
        )

        Text(
            text = stringResource(id = R.string.kazinca),
            fontFamily = Roboto,
            color = Color.Black,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight(400),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        )

    }
}