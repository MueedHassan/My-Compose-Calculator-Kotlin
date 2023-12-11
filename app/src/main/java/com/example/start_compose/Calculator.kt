package com.example.start_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.start_compose.ui.theme.darkgrey
import com.example.start_compose.ui.theme.lightgrey
import com.example.start_compose.ui.theme.orange

import androidx.compose.ui.text.TextStyle

@Composable
fun Calculator(
    state: CalculatorState,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier,
    viewmodel: CalculatorViewModel,
){
    val buttonSpacing: Dp = 8.dp
    var viewmodel: CalculatorViewModel=viewmodel
    Box ( modifier=modifier

    ){ Column(modifier= Modifier
        .fillMaxSize()
        .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing))
      {
          Box (
              Modifier
                  .height(290.dp)
                  .fillMaxSize()


          ){ println(" operation ${state.number1}")
              Text(
              text = "${state.number1}   ${state.operator}    ${state.number2}",

              // Display a default text if yourNullableText is null
              color = orange,
              modifier = Modifier
                  .fillMaxSize()
                  .padding(vertical = 36.dp),
              maxLines = 2,
              style = TextStyle(
                  fontSize = 20.sp,
                  textAlign = TextAlign.Right,
              ))

          }

          Row (

                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)

            ){
                  CalculatorButton(

                      symbol="AC",
                      modifier= Modifier
                          .background(lightgrey)
                          .aspectRatio(2f)
                          .weight(2f),
                      onClick = { onAction(CalculatorAction.clear) }

                  )
                CalculatorButton(
                    symbol="Del",
                    modifier= Modifier
                        .background(lightgrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewmodel.onAction(CalculatorAction.delete) }

                )
                CalculatorButton(
                    symbol="/",
                    modifier= Modifier
                        .background(orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { viewmodel.operation("/") }

                )}

        Row (modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                    CalculatorButton(
                        symbol="7",
                        modifier= Modifier
                            .background(darkgrey)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.number(7)) }

                    )
                    CalculatorButton(
                        symbol="8",
                        modifier= Modifier
                            .background(darkgrey)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.number(8)) }

                    )
                    CalculatorButton(
                        symbol="9",
                        modifier= Modifier
                            .background(darkgrey)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.number(9)) }

                    )
                    CalculatorButton(
                        symbol="*",
                        modifier= Modifier
                            .background(orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { viewmodel.operation("*")}

                    )
                }
        Row (
                        modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)

                    ) {
                        CalculatorButton(
                            symbol = "4",
                            modifier = Modifier
                                .background(darkgrey)
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { onAction(CalculatorAction.number(4)) }

                        )
                        CalculatorButton(
                            symbol = "5",
                            modifier = Modifier
                                .background(darkgrey)
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { onAction(CalculatorAction.number(5)) }

                        )
                        CalculatorButton(
                            symbol = "6",
                            modifier = Modifier
                                .background(darkgrey)
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { onAction(CalculatorAction.number(6)) }

                        )
                        CalculatorButton(
                            symbol = "-",
                            modifier = Modifier
                                .background(orange)
                                .aspectRatio(1f)
                                .weight(1f),
                            onClick = { viewmodel.operation("-") }

                        )
                    }
        Row (
                            modifier=Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)

                        ) {
                            CalculatorButton(
                                symbol = "1",
                                modifier = Modifier
                                    .background(darkgrey)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = { onAction(CalculatorAction.number(1)) }

                            )
                            CalculatorButton(
                                symbol = "2",
                                modifier = Modifier
                                    .background(darkgrey)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = { onAction(CalculatorAction.number(2)) }

                            )
                            CalculatorButton(
                                symbol = "3",
                                modifier = Modifier
                                    .background(darkgrey)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = { onAction(CalculatorAction.number(3)) }

                            )
                            CalculatorButton(
                                symbol = "+",
                                modifier = Modifier
                                    .background(orange)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = { viewmodel.operation("+")}

                            )
                        }
        Row (
                                modifier=Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),


                            ) {
                                CalculatorButton(
                                    symbol = "0",
                                    modifier = Modifier
                                        .background(darkgrey)
                                        .aspectRatio(2f)
                                        .weight(2f),
                                    onClick = { onAction(CalculatorAction.number(0)) }

                                )
                                CalculatorButton(
                                    symbol = ".",
                                    modifier = Modifier
                                        .background(darkgrey)
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { onAction(CalculatorAction.decimal) }

                                )
                                CalculatorButton(
                                    symbol = "=",
                                    modifier = Modifier
                                        .background(orange)
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = {viewmodel.performCalculation() }

                                )
                            }


     }






    }

    }



