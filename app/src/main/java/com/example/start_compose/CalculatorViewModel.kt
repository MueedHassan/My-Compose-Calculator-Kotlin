package com.example.start_compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.start_compose.CalculatorOperation.Calculate

class CalculatorViewModel :ViewModel(){
    var state by mutableStateOf(CalculatorState())
        private set
    fun  onAction(action:CalculatorAction){
        println("action $action action ")
        when(action){

            is CalculatorAction.number->enterNumber(action.number)
            is CalculatorAction.decimal->enterDecimal()
            is CalculatorAction.clear->state= CalculatorState()
            is CalculatorAction.delete->performDeletion()
            is CalculatorAction.Operation->enterOperation(action.operation)
            is CalculatorAction.calculate->performCalculation()
        }
    }

    fun operation(operator:String){
        if(state.number1.isNotBlank())
        {
            state=state.copy(

                operator=operator
            )
            println("oper ${state.operation}")
        }

    }

     fun performCalculation() {
        var number1=state.number1.toDoubleOrNull()
        var number2=state.number2.toDoubleOrNull()
        var result:Double=0.0

        if(state.operator.isNotBlank() && state.number2!=null && state.number1!=null){
            if(state.operator=="+")
            {
                result= number1!! + number2!!
            }
            if(state.operator=="-")
            {
                result= number1!! - number2!!
            }
            if(state.operator=="*")
            {
                 result= number1!! * number2!!
            }
            if(state.operator=="/")
            {
                 result= number1!! / number2!!
            }
                state=state.copy(

                    number1=result.toString().take(15),

                    number2="",
                    operator=""
                )




        }
    }

    private fun enterOperation(oper: CalculatorOperation) {

        if(state.number1.isNotBlank())
        {
            state=state.copy(

            operation=oper
        )
            println("oper ${state.operation}")
        }
    }

    private fun performDeletion() {
      if(state.number1.isNotBlank())
      {
          if(state.operator.isNotBlank())
          {
              if(state.number2.isNotBlank()){
                  state=state.copy(
                      number2 = state.number2.dropLast(1))
              }
              else{
                  state=state.copy(
                      operator =""
                  )
              }
          }
          else
          {
              state=state.copy(
                  number1=state.number1.dropLast(1)
              )
          }
      }
    }

    private fun enterDecimal() {
        if(state.operator.isBlank() && state.number1.isNotBlank() && !state.number1.contains("."))
        {
            state=state.copy(
                number1=state.number1+"."
            )
        }
        if(state.operator.isNotBlank() && state.number2.isNotBlank() && !state.number2.contains("."))
        {
            state=state.copy(
                number2=state.number2+"."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operator.isBlank() )
        {
            state=state.copy(
                number1=state.number1 +number
            )
        }
        else if(state.operator.isNotBlank() )
        {
            state=state.copy(
                number2=state.number2+number
            )
        }

    }
}

