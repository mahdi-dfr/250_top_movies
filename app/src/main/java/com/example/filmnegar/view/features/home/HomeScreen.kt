import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.filmnegar.view.features.home.HomeViewModel
import com.example.filmnegar.view.features.home.widgets.CategoryBox
import com.example.filmnegar.view.theme.FilmNegarTheme
import com.example.filmnegar.view.theme.customOnSecondaryColor
import javax.inject.Inject

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FilmNegarTheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val configuration = LocalConfiguration.current
    val scrollState = rememberScrollState()
    Log.i("TAG", "HomeeeeeeScreen: "+viewModel.movies.toString())


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .verticalScroll(state = scrollState)
    ) {
        val pagerState = rememberPagerState(pageCount = {
            4
        })
        HorizontalPager(state = pagerState) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(horizontal = 1.dp),
                backgroundColor = customOnSecondaryColor
            ) {

            }

//            Card(
//                Modifier
//                    .size(200.dp)
//                    .graphicsLayer {
//                        val pageOffset = (
//                                (pagerState.currentPage - page) + pagerState
//                                    .currentPageOffsetFraction
//                                ).absoluteValue
//
//                        // We animate the alpha, between 50% and 100%
////                        alpha = lerp(
////                            start = 0.5f,
////                            stop = 1f,
////                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
////                        )
//                    }
//            ) {
//                // Card content
//            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        CategoryBox(boxTitle = "فیلم")

        Spacer(modifier = Modifier.height(20.dp))

        CategoryBox(boxTitle = "سریال")

        Spacer(modifier = Modifier.height(20.dp))

        CategoryBox(boxTitle = "اکشن")

        Spacer(modifier = Modifier.height(20.dp))

        CategoryBox(boxTitle = "انیمیشن")

        Spacer(modifier = Modifier.height(20.dp))

        CategoryBox(boxTitle = "عاشقانه")

        Spacer(modifier = Modifier.height(80.dp))


    }

}