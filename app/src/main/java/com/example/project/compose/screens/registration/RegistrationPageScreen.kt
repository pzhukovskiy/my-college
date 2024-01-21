package com.example.project.compose.screens.registration

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.R
import com.example.project.auth.SignInState
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto

@Composable
fun RegistrationPageScreen(
    state: SignInState,
    onSignInClick: () -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }
    }


    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(top = 50.dp)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .weight(0.2f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column {
                        Text(
                            text = "Мой колледж",
                            fontFamily = Roboto,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(700),
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "Расписание всегда под рукой",
                            fontFamily = Roboto,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(400),
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .clickable {
                        onSignInClick()
                    }
                    .background(Color(PrimaryBlue.toArgb())),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Начать",
                    fontFamily = Roboto,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(500)
                )
            }
        }
    }
}