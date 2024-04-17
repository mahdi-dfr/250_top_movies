package com.example.filmnegar.view.features.home.movie

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Colors

import androidx.compose.material3.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.Coil
import coil.compose.AsyncImage
import com.example.filmnegar.utils.MyScreens
import com.example.filmnegar.utils.actorsList
import com.example.filmnegar.utils.writerList
import com.example.filmnegar.view.features.home.widgets.ImageCard
import com.example.filmnegar.view.features.home.widgets.WorkerItem
import com.example.filmnegar.view.theme.Typography
import com.example.filmnegar.view.theme.myFontFamily

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieScreen() {
    val scrollState = rememberScrollState()
    val likeIcon = remember { mutableStateOf(false) }

    Column(
        Modifier
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {

        ImageCard(
            url = "https://cdn.vox-cdn.com/thumbor/0w5aZu5XweQgRK_Ljoyq9Her8N8=/0x0:1200x800/1200x800/filters:focal(502x21:694x213)/cdn.vox-cdn.com/uploads/chorus_image/image/73167146/Dune2_LegendaryEntertainment_Getty_Ringer.0.jpg",
            title = "Dune 2024",
            imdb = "8.1"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = {
                likeIcon.value = !likeIcon.value
            }) {
                if (likeIcon.value) {
                    Icon(Icons.Filled.Favorite, tint = Color.Red, contentDescription = "")
                } else {
                    Icon(Icons.Default.FavoriteBorder, tint = Color.White, contentDescription = "")
                }
            }

            Text(
                text = "تل ماسه",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold,
                fontFamily = myFontFamily,
            )

        }

        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = ":بازیگران",
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = myFontFamily,
        )

        Spacer(modifier = Modifier.height(8.dp))
        LazyRow() {
            items(actorsList) { item ->
                WorkerItem(title = item)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = ":خلاصه داستان",
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = myFontFamily,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ، و با استفاده از طراحان گرافیک است، چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است، و برای شرایط فعلی تکنولوژی مورد نیاز، و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد، کتابهای زیادی در شصت و سه درصد گذشته حال و آینده، شناخت فراوان جامعه و متخصصان را می طلبد، تا با نرم افزارها شناخت بیشتری را برای طراحان رایانه ای علی الخصوص طراحان خلاقی، و فرهنگ پیشرو در زبان فارسی ایجاد کرد، در این صورت می توان امید داشت که تمام و دشواری موجود در ارائه راهکارها، و شرایط سخت تایپ به پایان رسد و زمان مورد نیاز شامل حروفچینی دستاوردهای اصلی، و جوابگوی سوالات پیوسته اهل دنیای موجود طراحی اساسا مورد استفاده قرار گیرد.",
            color = Color.White,
            textAlign = TextAlign.Right,
            fontFamily = myFontFamily,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = ":کارگردان", fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = myFontFamily,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.border(
                width = 1.dp, color = Color.White, shape = RoundedCornerShape(15.dp)
            ), shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "کارگردان1",
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = myFontFamily,
                modifier = Modifier.padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = ":نویسندگان", fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = myFontFamily,
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow() {
            items(writerList) { item ->
                WorkerItem(item)
            }
        }


        Spacer(modifier = Modifier.height(100.dp))


    }
}