package com.example.start_compose

data class CalculatorState(
    val number1:String="",
    val number2:String="",
    val operator:String="",
    val operation: CalculatorOperation?=null


)