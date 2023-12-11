package com.example.start_compose

sealed class CalculatorOperation(var symbol:String) {
    object Add:CalculatorOperation("+")
    object Subtract:CalculatorOperation("-")
    object Multiply:CalculatorOperation("*")
    object Divide:CalculatorOperation("/")
    object Calculate:CalculatorOperation("=")

}