package com.example.firstcomposedemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposedemo.ui.theme.FirstComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        Text(text = "Hello $name!")
        Text(text = "wie geht es dir?", fontSize = 24.sp )
        Row() {
            Button(onClick = { /*TODO*/ } ,) {
                Text(text = "Gut")
            }
            Button(onClick = { /*TODO*/ } ,
            modifier = Modifier.padding(start =  8.dp)) {
                Text(text = "Schlecht")
            }
        }
        Box() {
            Image(painter = painterResource(id = R.drawable.kitten_small),
                contentDescription = "Mein Bild von einer Katze" ,
            modifier = Modifier.padding(8.dp)
                .clip(CircleShape)
                .border(width = 2.dp,Color.Black, CircleShape)
                .border(width = 4.dp,Color.Red, CircleShape)
                .border(width = 6.dp,Color.Yellow, CircleShape)
                .border(width = 8.dp,Color.Blue, CircleShape)
            )

            Text(
                text = "Meine Katze",
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                color = Color.LightGray
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeDemoTheme {
        Greeting("Kotlin")
    }
}

//@Preview( uiMode =  Configuration.UI_MODE_NIGHT_YES,
//        showBackground = true,
//        name =  "DarkMode")
//@Composable
//fun NightPreview() {
//    FirstComposeDemoTheme {
//        Greeting("Kotlin")
//    }
//}