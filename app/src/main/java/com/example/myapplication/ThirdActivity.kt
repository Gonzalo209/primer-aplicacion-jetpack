package com.example.myapplication


import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.ui.theme.MyApplicationTheme

class ThirdActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

                ApplicationEnglish()

            }
        }

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationEnglish() {

    val context = LocalContext.current

    Column (modifier = Modifier
        .fillMaxSize()
    ) {

        MediumTopAppBar(
            title = { Text(text = "Welcome") },
            navigationIcon = {

                IconButton(
                    onClick = {
                        (context as? Activity)?.finish()
                    }
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Blue)

                }
            }
        )

    }

}
