package com.onats.composeformfield.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import kotlin.reflect.KProperty

class FormFieldScreenStates(
    var email: MutableState<String>,
    var firstName: MutableState<String>,
    var lastName: MutableState<String>,
    var middleName: MutableState<String>,
    var shouldRemember: MutableState<Boolean>
) {

    operator fun getValue(nothing: Nothing?, property: KProperty<*>): FormFieldScreenStates {
        return this
    }
}


@Composable
fun rememberFormFieldStates(
    email: MutableState<String> = rememberSaveable { mutableStateOf("") },
    firstName: MutableState<String> = rememberSaveable { mutableStateOf("") },
    lastName: MutableState<String> = rememberSaveable { mutableStateOf("") },
    middleName: MutableState<String> = rememberSaveable { mutableStateOf("") },
    shouldRemember: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) }
) = remember(email, firstName, lastName, middleName, shouldRemember) {
    FormFieldScreenStates(email, firstName, lastName, middleName, shouldRemember)
}