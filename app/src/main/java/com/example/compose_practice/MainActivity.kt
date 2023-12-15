package com.example.compose_practice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "first",
            ) {
                composable("first") {
                    FirstScreen(navController)
                }
                composable("Second") {
                    SecondScreen(navController)
                }
                composable("third/{value}") { backStackEntry ->
                    ThirdScreen(
                        navController = navController,
                        value = backStackEntry.arguments?.getString("value") ?: ""
                    )
                }
            }

        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController) {
    val (value, setValue) = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "첫번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second")
        }) {
            Text(text = "두번째 화면 이동!!")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = value, onValueChange = setValue)
        Button(onClick = {
            navController.navigate("third/$value") // 값 넘기기
        }) {
            Text(text = "세번째 화면 이동!!")
        }
    }
}

@Composable
fun SecondScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "두번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigateUp()
            navController.popBackStack()
        }) {
            Text(text = "뒤로가기")
        }
    }
}

@Composable
fun ThirdScreen(navController: NavHostController, value: String) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "세번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = value)
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text(text = "뒤로가기")
        }
    }
}
