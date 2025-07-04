package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(Modifier.weight(weight = 1F)) {
            Quadrant(
                quadrantResourceId = R.string.text_composable,
                textContentId = R.string.first_quadrant_text,
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1F)
            )
            Quadrant(
                quadrantResourceId = R.string.image_composable,
                textContentId = R.string.second_quadrant_text,
                backgroundColor =  Color(0xFFD0BCFF),
                modifier = Modifier.weight(1F)
            )
        }
        Row(Modifier.weight(1F)) {
            Quadrant(
                quadrantResourceId = R.string.row_composable,
                textContentId = R.string.third_quadrant_text,
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            Quadrant(
                quadrantResourceId = R.string.column_composable,
                textContentId = R.string.fourth_quadrant_text,
                backgroundColor= Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun Quadrant(quadrantResourceId: Int, textContentId: Int,backgroundColor:Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(id = quadrantResourceId),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = stringResource(id = textContentId))
    }
}


@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}