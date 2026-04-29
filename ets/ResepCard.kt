package com.example.resepkita

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resepkita.ui.theme.ResepKitaTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton


val listWarna = listOf(
    Color(0xFFC4D6FF),
    Color(0xFFD0C4FF),
    Color(0xFFFFC4EC),
    Color(0xFFFFD9C4),
    Color(0xFFD7FFBA),
    Color(0xFFFFF6BA)
)
@Composable
fun ResepCard(
    resep: Resep,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val warnaKartu = listWarna[resep.id % listWarna.size]
    var isDisukai by remember { mutableStateOf(false) }

    Card(

        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = warnaKartu),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(id = resep.gambarId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { isDisukai = !isDisukai },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .size(24.dp)
                        .background(Color.White.copy(alpha = 0.6f), shape = RoundedCornerShape(50))
                ) {
                    Icon(
                        imageVector = if (isDisukai) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Suka",
                        tint = if (isDisukai) Color(0xFFFF4B4B) else Color.DarkGray,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = resep.namaMakanan,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF2D2D2D),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResepCardPreview() {
    ResepKitaTheme {
        ResepCard(
            resep = DataPalsu.daftarResep[0],
            onClick = {}
        )
    }
}