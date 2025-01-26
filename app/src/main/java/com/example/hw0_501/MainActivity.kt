package com.example.hw0_501

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column // for centering
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf // Can't change text and update UI
import androidx.compose.runtime.remember // Can't change text and update UI
import androidx.compose.ui.Alignment // for centering elements
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw0_501.ui.theme.Hw0_501Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw0_501Theme {
                ButtonHello()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true) // so I can see changes in preview
@Composable
fun ButtonHello() {
    // Can't just have a val/variable and change it - for some reason doesn't work in Kotlin
    // Can't even call another method, get error regarding calling composable within composable
    val displayText = remember { mutableStateOf("") }

    Column( // use to center button and text
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, // Center Vertically button and text
        horizontalAlignment = Alignment.CenterHorizontally, // Center Horizontally button and text
    ) {
        Button(onClick = {
            displayText.value = "Hello World"
        }) {
            Text("Button")
        }
        DisplayText(displayText.value)
    }
}

// Calling another method to display text
// for some reason cannot get this to show up in preview, but works in build
@Composable
fun DisplayText(text: String) {
    if (text.isNotEmpty()) { // so only display text once vs creating more text every time button is clicked
        Text(text)
    }
}