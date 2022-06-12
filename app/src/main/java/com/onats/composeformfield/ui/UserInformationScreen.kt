package com.onats.composeformfield.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onats.composeformfield.R
import com.onats.composeformfield.states.rememberFormFieldStates

@Composable
fun UserInformationScreen() {

    val infoScreenState by rememberFormFieldStates()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.user_info_header),
                style = TextStyle(
                    fontWeight = FontWeight.W600,
                    fontSize = 24.sp,
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
            TextField(
                value = infoScreenState.firstName.value,
                onValueChange = { infoScreenState.firstName.value = it },
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(top = 20.dp),
                label = {
                    Text(text = "First Name")
                }
            )
            TextField(
                value = infoScreenState.lastName.value,
                onValueChange = { infoScreenState.lastName.value = it },
                label = {
                    Text(text = "Last Name")
                },
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(top = 20.dp),
            )
            TextField(
                value = infoScreenState.middleName.value,
                onValueChange = { infoScreenState.middleName.value = it },
                label = {
                    Text(text = "Middle Name")
                },
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(top = 20.dp),
            )
            TextField(
                value = infoScreenState.email.value,
                onValueChange = { infoScreenState.email.value = it },
                label = {
                    Text(text = "Email Address")
                },
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(top = 20.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = infoScreenState.shouldRemember.value,
                    onCheckedChange = { infoScreenState.shouldRemember.value = it }
                )
                Text(text = "Remember details.")
            }
            Button(
                onClick = { },
                modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp),
                colors = buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                ),
                shape = RoundedCornerShape(20.dp),
                enabled = infoScreenState.buttonState.value
            ) {
                Text(text = "Proceed")
            }
        }
    }
}

@[Composable Preview]
private fun UserInfoScreenPreview() {
    UserInformationScreen()
}