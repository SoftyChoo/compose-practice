package com.example.compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isFavorite by rememberSaveable {
                mutableStateOf(false)
            }
            ImageCard(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp),
                isFavorite = isFavorite
            ) { favorite ->
                isFavorite = favorite
            }
        }
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.choo),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = {
                    onTabFavorite(!isFavorite)
                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "favorite",
                    tint = Color.White
                )
            }
        }
    }
}

//ComposepracticeTheme {
//    Surface(
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("Android")
//    }
//}

//@Composable
//fun Greeting(name : String){
//    Text(text = "Hello $name")
//}
//
//
//
////// 박스
//@Preview(showBackground = true)
//@Composable
//fun BoxPreview() {
//    Box(
//        modifier = Modifier
//            .background(color = Color.Green)
//            .fillMaxWidth()
//            .height(200.dp),
//    ) {
//        Text(text = "Hello")
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            contentAlignment = Alignment.BottomEnd,
//        ){
//            Text(text = "Hello!!!!!!")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ListPreview() {
//    val scrollState = rememberScrollState()
//    Column(
//        modifier = Modifier
//            .background(color = Color.Green)
//            .fillMaxWidth()
//            .verticalScroll(state = scrollState)
//    ) {
//        for(i in 1..50){
//            Text(text = "글씨 $i")
//        }
//    }
//}