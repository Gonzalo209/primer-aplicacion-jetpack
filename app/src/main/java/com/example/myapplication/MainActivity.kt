package com.example.myapplication


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

                Home()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Home() {

    Column(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        .padding(horizontal = 5.dp)
    ) {

        CreateText("Welcome")
        Space()
        CreateText("Choose")
        Space()
        CreateText("some")
        Space()
        CreateText("language")
        CreateButton("Spanish", SecondActivity::class.java)
        Space()
        CreateButton("English", ThirdActivity::class.java)

    }

}

@Composable
fun CreateButton(text: String, activity: Class<out Activity>) {

    val context = LocalContext.current

    Button(onClick = {

        context.startActivity(Intent(context, activity))

    }, modifier = Modifier
        .padding(horizontal = 30.dp)
        .fillMaxWidth()) {

        Text(text,
            fontSize = 40.sp,
        )

    }

}

@Composable
fun CreateText(text: String) {

    Text(text,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth())

}

@Composable
fun Space() {

    Spacer(modifier = Modifier.height(10.dp))

}