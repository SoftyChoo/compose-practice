package com.example.compose_practice

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _data = mutableStateOf("Hello")
    val data : State<String> get() =  _data

    fun updateValue(value : String){
        _data.value = value
    }
}