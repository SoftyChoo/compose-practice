package com.example.compose_practice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_practice.ui.theme.ComposepracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposepracticeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(names : List<String> = listOf("World","Compose")) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            for (name in names){
                Greeting(name = name)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Column(modifier = Modifier.padding(24.dp).fillMaxWidth(1f)) {
            Text(text = "Hello")
            Text(text = name)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposepracticeTheme {
        MyApp()
    }
}


//@Composable
//fun HomeScreen(lifecycleOwner: MainActivity, viewModel: MainViewModel = viewModel()) {
//
//    val (text, setText) = remember {
//        mutableStateOf("Hello world")
//    }
//
////    viewModel.value.observe(lifecycleOwner, Observer {
////        setUiText(it)
////    })
//
//    val uiText = viewModel.value.observeAsState("")
//
//
//    Column {
//        Text(text = uiText.value)
//        TextField(value = text, onValueChange = setText )
//        Button(onClick = {
//            viewModel.updateValue(text)
//        }) {
//            Text(text = "클릭")
//        }
//    }
//}
