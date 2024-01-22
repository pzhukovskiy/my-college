package com.example.project.compose.screens.contacts

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.data.contacts.Contacts
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import java.util.UUID

@Composable
fun ContactsPageScreen(
    onBackClick: () -> Unit,
    context: Context
) {
    val uuid = UUID.randomUUID()

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
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        ),
        Contacts(
            id = uuid.toString(),
            position = stringResource(id = R.string.director),
            name = stringResource(id = R.string.director_name),
            telephone = stringResource(id = R.string.director_telephone)
        )
    )

    Column {
        StaticHeaderWidget(
            text = stringResource(id = R.string.link_contacts),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = {
                onBackClick()
            }
        )

        LazyColumn(content = {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.kazinca),
                        fontFamily = Roboto,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(400),
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }
            }
            items(contactsListKazinca) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row {
                        Box(
                            modifier = Modifier
                                .height(60.dp)
                                .weight(0.7f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = it.position)
                        }
                        Box(
                            modifier = Modifier
                                .height(60.dp)
                                .weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = it.name)
                        }
                        Box(
                            modifier = Modifier
                                .height(60.dp)
                                .weight(0.6f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = it.telephone,
                                fontFamily = Roboto,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(400),
                                color = Color(PrimaryBlue.toArgb()),
                                modifier = Modifier
                                    .clickable {
                                        val phoneNumber = it.telephone
                                        val intent = Intent(Intent.ACTION_DIAL).apply {
                                            data = Uri.parse("tel:$phoneNumber")
                                        }

                                        if (intent.resolveActivity(context.packageManager) != null) {
                                            context.startActivity(intent)
                                        } else {
                                            Toast
                                                .makeText(context, "Невозможно открыть приложение", Toast.LENGTH_LONG)
                                                .show()
                                        }
                                    }
                            )
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(45.dp))
            }
        })
    }
}