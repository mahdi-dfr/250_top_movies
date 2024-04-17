package com.example.filmnegar.view.features.home.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmnegar.view.theme.myFontFamily

@Composable
fun WorkerItem(
    title: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Card(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = myFontFamily,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}