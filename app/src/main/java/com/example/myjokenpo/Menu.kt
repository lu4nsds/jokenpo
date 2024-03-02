package com.example.myjokenpo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myjokenpo.ui.theme.MyJokenpoTheme
import com.example.myjokenpo.ui.theme.Purple80
import myHorizontalPage


@Composable
fun Menu(navController: NavHostController) {
    MyJokenpoTheme {
        Surface(
            color = Purple80,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .background(
                        color = Purple80,
                    )
            ) {
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                Text(
                    text = "Choose your hand",
                    color = Color.White,
                    fontSize = 40.sp,
                )
                Spacer(
                    modifier = Modifier
                        .height(9.dp)
                )
                myHorizontalPage(navController)
            }
        }
    }


}