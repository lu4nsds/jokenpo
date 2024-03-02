package com.example.myjokenpo
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myjokenpo.ui.theme.Purple80
import com.example.myjokenpo.ui.theme.PurpleGrey80
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun Battle(choose: String, navController: NavController){

   val randomImage = remember { mutableStateOf(R.drawable.tesoura) }
   val composableScope = rememberCoroutineScope()
   val sliderList = listOf(R.drawable.pedra, R.drawable.papel,R.drawable.tesoura)
   var randomNumberImage = 0
   val result = remember { mutableStateOf("") }
   val resultAvailabel = remember { mutableStateOf(false) }


   LaunchedEffect(
      key1 = randomImage,
   ) {
      composableScope.launch {
         for (i in 1..15) {
            delay(300L)
            randomNumberImage = (0..2).random()
            randomImage.value = sliderList[randomNumberImage]
         }
         if (choose.toInt() == 0){
            if (randomNumberImage == 0) result.value = "Draw"
            else if (randomNumberImage == 2) result.value = "Win"
            else result.value = "Lose"
         }
         if (choose.toInt() == 1){
            if (randomNumberImage == 0) result.value = "Win"
            else if (randomNumberImage == 2) result.value = "Lose"
            else result.value = "Draw"
         }
         if (choose.toInt() == 2){
            if (randomNumberImage == 0) result.value = "Lose"
            else if (randomNumberImage == 1) result.value = "Win"
            else result.value = "Draw"
         }
         resultAvailabel.value = true
      }
   }

   Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
         .fillMaxSize()
         .background(
            color = Purple80,
         )
         .padding(
            all = 30.dp
         )
   ) {
      Text(
         text = "Battle",
         fontSize = 40.sp,
         color = Color.White
         )
      Spacer(modifier = Modifier
         .height(20.dp)
      )
      Box(
         contentAlignment = Alignment.Center
      ) {
         Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
               .fillMaxWidth()
               .padding(5.dp)
         ) {
            Box(
               modifier = Modifier
                  .weight(1f)
                  .padding(2.dp)
            ) {
               Image(
                  painter = painterResource(id = sliderList[choose.toInt()]),
                  contentDescription = "Papel",
                  modifier = Modifier
                     .clip(
                        shape = RoundedCornerShape(
                           10.dp
                        )
                     )
               )
            }
            Box(
               modifier = Modifier
                  .weight(1f)
                  .padding(2.dp)
            ) {
               Image(
                  painter = painterResource(id = randomImage.value),
                  contentDescription = "Papel",
                  modifier = Modifier
                     .clip(
                        shape = RoundedCornerShape(
                           10.dp
                        )
                     )
               )
            }
         }
         Box(
            modifier = Modifier
               .height(60.dp)
         ) {
            Image(
               painter = painterResource(id = R.drawable.vs),
               contentDescription = "Papel",
               modifier = Modifier
                  .clip(
                     shape = CircleShape
                  )
                  .background(color = Color.Transparent)
            )
         }
      }
      if (resultAvailabel.value){
         Spacer(modifier = Modifier
            .height(40.dp)
         )
         Text(
            text = "You ${result.value}",
            fontSize = 40.sp,
            color = Color.White
         )
         Spacer(modifier = Modifier
            .height(40.dp)
         )
         Button(
            onClick = { navController.popBackStack()},
            shape = RoundedCornerShape(10.dp)
         ) {
            Text(text = "Play Again")
         }
      }
   }
}

@Preview
@Composable
fun BattlePreview() {
   val navController = rememberNavController()
   Battle(0.toString(), navController = navController)
}