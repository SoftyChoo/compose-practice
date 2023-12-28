package com.example.compose_practice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_practice.ui.theme.ComposepracticeTheme
import com.example.compose_practice.ui.theme.Purple40
import com.example.compose_practice.ui.theme.Purple80

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
fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = rememberSaveable { mutableStateOf(false) }
    val extraPadding = if(expanded.value) 64.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .padding(bottom = extraPadding)
                    .weight(1f) // 겹치지 않게 Weight로 설정
            ) {
                Text(text = "Hello", color = Color.White)
                Text(text = name, color = Color.White)
            }
            OutlinedButton(onClick = {
                expanded.value = !expanded.value
            }, colors = ButtonDefaults.buttonColors(Color.White)) {
                Text(
                    if (expanded.value) "Show less" else "Show more",
                    color = Purple40
                )
            }
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
