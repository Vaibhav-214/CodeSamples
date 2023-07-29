package com.example.unscramble2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscramble2.Greeting
import com.example.unscramble2.ui.theme.Unscramble2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Section1(
    scrambledword : String,
    questionNum: Int,
    textFieldValue: String,
    onValueChange: (String) -> Unit
) {

//    var text = remember {
//        mutableStateOf("")
//    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .background(Color.Red)
                    .height(30.dp)
                    .width(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$questionNum/10")
            }
        }

        Text(text = "$scrambledword", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Unscramble the word using all the letters")

        Spacer(modifier = Modifier.height(10.dp))


        TextField(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .border(width = 2.dp, color = Color.Black)
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Black
                ),
            value = textFieldValue, onValueChange = { onValueChange(it)}
        )

    }

}

@Composable
fun Section2(
    score: Int,
    changeWord: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.width(300.dp),
            onClick = { changeWord("ogd") }) {
            Text(text = "Submit")
        }
        
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier.width(300.dp),
            border = ButtonDefaults.outlinedButtonBorder,
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Blue)
            ) {
            Text(text = "Skip")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card (
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ){

            Text(modifier = Modifier.padding(10.dp), text = "Score: $score", fontSize = 20.sp)

        }
    }
}

@Composable
fun Unscramble () {

    val viewModel: UnscrambleViewModel = viewModel()

    val composeUiState = viewModel.uiState.collectAsState().value

    val word = "scrambleun"
    val questionNum = 1
    val score = 0


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
//        var word = remember { mutableStateOf(word) }
//        var questionNum = remember { mutableStateOf(questionNum) }
//        var score = remember { mutableStateOf(score) }

        var textInsideTextField = remember {
            mutableStateOf("vaibhav")
        }

        Text(text = "Unscramble", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Section1(scrambledword = composeUiState.currentWord,
            questionNum = composeUiState.questionNum,
            textFieldValue = textInsideTextField.value,
            onValueChange = {typedValue ->
                textInsideTextField.value = typedValue

            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Section2(
            score = composeUiState.score,
            changeWord = {viewModel.updateWord(it)}
            )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unscramble2Theme {
       // Section1()
        //Section2()
       // Unscramble()
        Greeting(name = "l")
    }

}