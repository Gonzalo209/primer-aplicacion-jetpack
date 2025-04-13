package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ApplicationSpanish()
            }
        }
    }
}

@Composable
fun ApplicationSpanish() {
    val context = LocalContext.current
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CreateMediumTopAppBar(context)

        CreateDropdownMenu(onOptionSelected = { selectedOption = it })

        selectedOption?.let { option ->
            Option(option)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateMediumTopAppBar(context: Context) {
    MediumTopAppBar(
        title = { Text(text = "Bienvenido") },
        navigationIcon = {
            IconButton(
                onClick = {
                    (context as? Activity)?.finish()
                }
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Regresar",
                    tint = Color.Blue
                )
            }
        }
    )
}

@Composable
fun CreateDropdownMenu(onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(onClick = { expanded = !expanded }) {
            Text("Seleccione una fórmula")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Raíz de ecuación de segundo grado") },
                onClick = {
                    onOptionSelected("raiz")
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Volumen de cilindro") },
                onClick = {
                    onOptionSelected("cilindro")
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Ley de Ohm") },
                onClick = {
                    onOptionSelected("ohm")
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Volumen de círculo") },
                onClick = {
                    onOptionSelected("circulo")
                    expanded = false
                }
            )
        }
    }
}

@Composable
fun Option(select: String) {
    var a by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }
    var c by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (select) {
            "raiz" -> {
                CreateText("Ingrese los valores, por favor")
                Spacer(modifier = Modifier.height(12.dp))
                a = CreateTextField("a:")
                Spacer(modifier = Modifier.height(12.dp))
                b = CreateTextField("b:")
                Spacer(modifier = Modifier.height(12.dp))
                c = CreateTextField("c:")
                Spacer(modifier = Modifier.height(20.dp))
                // Aquí puedes llamar a NewButton con la conversión de a, b, c
                NewButton(a.toFloatOrNull() ?: 0f, b.toFloatOrNull() ?: 0f, c.toFloatOrNull() ?: 0f, "raiz")
            }

            "cilindro" -> {
                CreateText("Ingrese el valor, por favor")
                Spacer(modifier = Modifier.height(12.dp))
                a = CreateTextField("Radio:")
                Spacer(modifier = Modifier.height(12.dp))
                b = CreateTextField("Altura:")
                NewButton(a.toFloatOrNull() ?: 0f, b.toFloatOrNull() ?: 0f, 0.0f, "cilindro")
            }

            "ohm" -> {
                CreateText("Ingrese los valores de la fórmula")
                Spacer(modifier = Modifier.height(12.dp))
                a = CreateTextField("Voltaje:")
                Spacer(modifier = Modifier.height(12.dp))
                b = CreateTextField("Resistencia:")
                NewButton(a.toFloatOrNull() ?: 0f, b.toFloatOrNull() ?: 0f, 0.0f, "ohm")
            }

            "circulo" -> {
                CreateText("Ingrese el radio del círculo")
                Spacer(modifier = Modifier.height(12.dp))
                a = CreateTextField("Radio:")
                NewButton(a.toFloatOrNull() ?: 0f, 0.0f, 0.0f, "circulo")
            }
        }
    }
}

@Composable
fun CreateTextField(texto: String): String {
    var valor by remember { mutableStateOf("") }

    TextField(
        value = valor,
        onValueChange = { nuevoValor ->
            if (nuevoValor.matches(Regex("^-?\\d*\\.?\\d*\$"))) {
                valor = nuevoValor
            }
        },
        label = { Text(texto) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )

    return valor
}

@Composable
fun NewButton(a: Float, b: Float, c: Float, action: String) {
    var x1 by remember { mutableStateOf("") }
    var x2 by remember { mutableStateOf("") }

    Button(
        onClick = {
            when(action) {
                "raiz" -> {
                    // Llamada a la función Raiz
                    x1 = "El resultado de x1 es: " + Raiz(a, b, c, "positivo").toString()
                    x2 = "El resultado de x2 es: " + Raiz(a, b, c, "negativo").toString()
                }
                "cilindro" -> {
                    x1 = "Volumen: " + (3.14159 * a * a * b).toString()
                }
                "ohm" -> {
                    x1 = "Corriente: " + (a / b).toString()
                }
                "circulo" -> {
                    x1 = "Área del círculo: " + (3.14159 * a * a).toString()
                }
            }
        },
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Calcular",
            fontSize = 24.sp
        )
    }


    Text("$x1", fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp))

    if(! x2.isEmpty()) Text("\n$x2", fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp))

}
