package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xFFDDEEDD)
                )
                {
                    CreateBusinessCard()
                }
            }
        }
    }
}

@Composable
fun CreateBusinessCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0x908DC090))
    ) {
        CreateMainContent()
        Spacer(Modifier.height(275.dp))
        CreateCommunicationContent()

    }
}


@Composable
fun CreateMainContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(30.dp)
            .fillMaxWidth()
    )
    {
        Box(
            modifier = Modifier
                .background(Color(0xDD000000))
                .width(120.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentScale = ContentScale.Inside,
                contentDescription = "Sample Mailbox Image",
            )
        }
        Text(
            text = "Jennifer Doe",
            fontSize = 35.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 14.sp,
            color = Color(0xF0257547),
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun CreateCommunicationContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth().padding(start = 70.dp)
    ) {
        ContactRow(Icons.Default.Phone, "+1 (123) 444 555 666")
        ContactRow(Icons.Default.Share, "@AndroidDev")
        ContactRow(Icons.Default.Email, "jen.doe@android.com")
    }
}

@Composable
fun ContactRow(icon: ImageVector, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(0.8f)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xF0257547),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(18.dp))
        Text(
            text = info,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        CreateBusinessCard()
//        BusinessCard()
    }
}