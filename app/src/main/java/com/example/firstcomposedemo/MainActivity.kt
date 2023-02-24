package com.example.firstcomposedemo


import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
                    Conversation(messages = messageList)
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello $name!")
        Text(text = "wie geht es dir?", fontSize = 24.sp)
        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Gut")
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Schlecht")
            }
        }
        Box() {
            Image(
                painter = painterResource(id = R.drawable.kitten_small),
                contentDescription = "Mein Bild von einer Katze",
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, Color.Black, CircleShape)
                    .border(width = 4.dp, Color.Red, CircleShape)
                    .border(width = 6.dp, Color.Yellow, CircleShape)
                    .border(width = 8.dp, Color.Blue, CircleShape)
            )

            Text(
                text = "Meine Katze",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                color = Color.LightGray
            )
        }

        var count by remember { mutableStateOf(0) }

        Button(onClick = { ++count }) {
            Text(text = "Counter")
            Log.d("TAG", "Greeting: $count")
        }
        Text(text = "$count")
    }
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.kitten_small),
            contentDescription = "Profilbild",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column() {
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }


    }
}

val messageList = listOf<Message>(
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
    Message("Hans","ein kleiner Text um das Beispiel besser zu erklären"),
)

@Composable
fun Conversation(messages: List<Message>){
    LazyColumn {
        items(messages){message ->
            MessageCard(msg = message)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    FirstComposeDemoTheme {
//        Greeting("Kotlin")
//    }
//}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    val message = Message("Frank Neumann", "eine kurze Nachricht")
    FirstComposeDemoTheme {
        Conversation(messages = messageList)
    }
}