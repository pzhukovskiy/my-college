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
import androidx.compose.material.Divider
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
            position = "Директор",
            name = "Козел Георгий Владимирович",
            telephone = "374 11 62"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Приемная",
            name = "Кислухина Светлана Анатольевна",
            telephone = "374 11 62"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Заместитель директора по УР",
            name = "Филипцова Елена Викторовна",
            telephone = "354 44 62"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Заместитель директора по УВР",
            name = "Сотникова Ольга Александровна",
            telephone = "374 31 80"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Заместитель директора по ПО",
            name = "Белобровик Анжела Анатольевна",
            telephone = "355 59 80"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Заместитель директора по ХР",
            name = "Тарусов Виктор Михайлович",
            telephone = "370 43 75"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Главный бухгалтер",
            name = "Метта Марина Владимировна",
            telephone = "300 40 44"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Бухгалтерия",
            name = "Мирошкина Марина Казимировна",
            telephone = "355 53 15"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Касса",
            name = "Козлова Татьяна Викторовна",
            telephone = "373 38 98"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Касса",
            name = "Зубова Нина Васильевна",
            telephone = "373 38 98"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Педагоги социальные",
            name = "Хващевская Ольга Николаевна",
            telephone = "357 59 43"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Педагоги социальные",
            name = "Модель Диана Радиковна",
            telephone = "357 59 43"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Методист",
            name = "Егорова Лариса Александровна",
            telephone = "374 83 13"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Юрист",
            name = "Демьянович Наталья Владимировна",
            telephone = "353 54 81"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Инспектор по кадрам",
            name = "Римошевская Инна Ивановна",
            telephone = "276 80 45"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Учебная часть",
            name = "Солтан-Михолап Ирина Васильевна",
            telephone = "358 45 07"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Учебная часть",
            name = "Василевич Наталья Анатольевна",
            telephone = "358 45 07"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Вычислительный центр",
            name = "Галицкий Максим Игоревич",
            telephone = "375 86 36"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Медпункт",
            name = "Короткая Оксана Леонидовна",
            telephone = "375 66 06"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Комендант",
            name = "Коршак Татьяна Антоновна",
            telephone = "320 40 43"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Пост охраны 1",
            name = "",
            telephone = "374 32 62"
        ),
        Contacts(
            id = uuid.toString(),
            position = "Пост охраны 2",
            name = "",
            telephone = "320 40 43"
        ),
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
                Divider()
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
                                .weight(0.4f),
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
                            Text(text = it.name, modifier = Modifier.padding(start = 8.dp))
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
                Divider()
            }
            item {
                Spacer(modifier = Modifier.height(45.dp))
            }
        })
    }
}