package com.example.myapplication

fun Raiz(a: Float, b: Float, c: Float, option: String): String {

    var text: String = "El valor de la ecuacion de segundo grado es de: "
    var result: Float = 0.0f

    when(option) {

        "positivo" -> {

            result = ((-b + Math.sqrt((((b * b) - (4 * a * c)).toDouble()))) / (2 * a)).toFloat()

        }

        "negativo" -> { result = ((-b + Math.sqrt((((b * b) - (4 * a * c)).toDouble()))) / (2 * a)).toFloat() }

    }

    text += "$result"

    return text

}