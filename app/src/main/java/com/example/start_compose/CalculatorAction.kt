package com.example.start_compose

sealed class CalculatorAction{
    data class number(val number:Int):CalculatorAction()
    object clear:CalculatorAction()
    object delete:CalculatorAction()
    object decimal:CalculatorAction()
    object calculate:CalculatorAction()
    data class Operation(val operation:CalculatorOperation):CalculatorAction()
}
