
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myjokenpo.Battle
import com.example.myjokenpo.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun myHorizontalPage(navController: NavHostController) {

    val sliderList = listOf(R.drawable.pedra, R.drawable.papel, R.drawable.tesoura)
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0.1F
    )
    HorizontalPager(
        modifier = Modifier
            .fillMaxSize(),
        state = pagerState,
        beyondBoundsPageCount = 1,
        pageCount = sliderList.size
    ) { page ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds(),
            contentAlignment = Alignment.Center
        ) {
            val context = LocalContext.current
            TextButton(
                shape = RectangleShape,
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(
                        height = maxHeight,
                        width = maxWidth,
                    ),
                onClick = {
                    navController.navigate( route = "battle/$page" )
                }
            ) {
                Image(
                    painter = painterResource(id = sliderList[page]),
                    contentDescription = "Image",
                    modifier = Modifier
                        .clip(
                        shape = RoundedCornerShape(
                            10.dp
                        )
                    )
                )
            }
        }

    }
}

@Preview
@Composable
fun myHorizontalPagePreview() {
    val navController = rememberNavController()
    myHorizontalPage(navController)
}