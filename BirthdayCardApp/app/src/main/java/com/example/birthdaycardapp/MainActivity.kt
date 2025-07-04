package com.example.birthdaycardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycardapp.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingWithImage(
                        message = stringResource(R.string.first_message),
                        to = stringResource(R.string.for_person),
                        from = stringResource(R.string.signature_text),
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color.Gray)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(text: String, to: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 80.sp,
            textAlign = TextAlign.Center,
            lineHeight = 100.sp,
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "$to !",
            fontSize = 80.sp,
            lineHeight = 100.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier= Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "From: $from",
            fontSize = 36.sp,
//            textAlign = TextAlign.Right,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingWithImage(message:String,to:String,from : String,modifier: Modifier=Modifier) {
//    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = painterResource(R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )

        GreetingText(
            text = message, from = from, to = to, modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GreetingCardPreview() {
    BirthdayCardTheme {
//        GreetingText("Happy day", to = "Android", from = "Android")
        GreetingWithImage("Happy Birthday",to="Android",from = "Android")
    }
}