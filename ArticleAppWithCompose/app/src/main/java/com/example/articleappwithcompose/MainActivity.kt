package com.example.articleappwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articleappwithcompose.ui.theme.ArticleAppWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleAppWithComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GreetingArticle(
                        articleHeading = stringResource(id = R.string.article_heading),
                        modifier = Modifier.background(Color.White))
                }
            }
        }
    }
}

@Composable
fun GreetingArticle(articleHeading: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentScale = ContentScale.Fit,
            contentDescription = "Some jetpack compose image"
        )
        Text(
            text = articleHeading,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(id = R.string.intro_text),
            textAlign = TextAlign.Justify,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(text = stringResource(id = R.string.paragraph_text),
            textAlign = TextAlign.Justify,
            color = Color.Black,
            modifier=Modifier.padding(16.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArticleAppWithComposeTheme {
        GreetingArticle("Jetpack Compose tutorial")
    }
}