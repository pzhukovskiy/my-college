package com.example.project.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var sharedValue: MutableState<Int> = mutableStateOf(0)
    var teacherValue: MutableState<String> = mutableStateOf("")
    var groupValue: MutableState<String> = mutableStateOf("")
}