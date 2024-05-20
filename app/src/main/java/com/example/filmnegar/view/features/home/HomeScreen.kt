
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.filmnegar.utils.MyScreens
import com.example.filmnegar.view.features.home.HomeViewModel
import com.example.filmnegar.view.features.home.widgets.CategoryBox
import com.example.filmnegar.view.theme.customPrimaryColor
import com.example.filmnegar.view.theme.myFontFamily


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val configuration = LocalConfiguration.current
    val scrollState = rememberScrollState()

    viewModel.getHomeScreenData()

    Log.i("TAG", "HomeScreennnn: "+viewModel.allMoviesData)



    Scaffold(
        topBar = {
            MyAppBar(navController=navController, haveBackButton = false)
        }


    ) { value ->


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(value)
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
                        .padding(1.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                ) {

                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            CategoryBox(boxTitle = "فیلم", onShowMoreClicked = {
                viewModel.getAllMoviesScreenData("movie")
                navController.navigate(MyScreens.AllMoviesScreen.rout)
            })

            Spacer(modifier = Modifier.height(20.dp))

//            CategoryBox(boxTitle = "سریال", viewModel.series.value, navigator = navController)
//
//            Spacer(modifier = Modifier.height(20.dp))

            CategoryBox(boxTitle = "اکشن", onShowMoreClicked = {
                viewModel.getAllMoviesScreenData("action")
                navController.navigate(MyScreens.AllMoviesScreen.rout)
            })

            Spacer(modifier = Modifier.height(20.dp))

            CategoryBox(boxTitle = "انیمیشن", onShowMoreClicked = {
                viewModel.getAllMoviesScreenData("Animation")
                navController.navigate(MyScreens.AllMoviesScreen.rout)
            })

            Spacer(modifier = Modifier.height(20.dp))

            CategoryBox(boxTitle = "عاشقانه", onShowMoreClicked = {
                viewModel.getAllMoviesScreenData("Drama")
                navController.navigate(MyScreens.AllMoviesScreen.rout)
            })

            Spacer(modifier = Modifier.height(20.dp))

            CategoryBox(boxTitle = "ماجراجویی", onShowMoreClicked = {
                viewModel.getAllMoviesScreenData("Adventure")
                navController.navigate(MyScreens.AllMoviesScreen.rout)
            })

            Spacer(modifier = Modifier.height(20.dp))



        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    navController: NavHostController,
    haveBackButton: Boolean
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = customPrimaryColor),

        title = {
            Text(
                text = "فیلم نگار",
                fontSize = 21.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = myFontFamily,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = if (haveBackButton) 60.dp else 16.dp, start = 16.dp)
            )
        },
        navigationIcon = {
            if(haveBackButton){
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        })
}
