package com.example.compose_practice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen(this)
        }
    }
}

@Composable
fun HomeScreen(lifecycleOwner: MainActivity, viewModel: MainViewModel = viewModel()) {

    val (text, setText) = remember {
        mutableStateOf("Hello world")
    }

//    viewModel.value.observe(lifecycleOwner, Observer {
//        setUiText(it)
//    })

    val uiText = viewModel.value.observeAsState("")


    Column {
        Text(text = uiText.value)
        TextField(value = text, onValueChange = setText )
        Button(onClick = {
            viewModel.updateValue(text)
        }) {
            Text(text = "클릭")
        }
    }
}
