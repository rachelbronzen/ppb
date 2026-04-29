package com.example.resepkita

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resepkita.ui.theme.ResepKitaTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@Composable
fun DetailScreen(resep: Resep, onNavigateBack: () -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        IconButton(
            onClick = onNavigateBack,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Kembali"
            )
        }
        Image(
            painter = painterResource(id = resep.gambarId),
            contentDescription = "Gambar ${resep.namaMakanan}",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = resep.namaMakanan,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Bahan-bahan",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))

            resep.daftarBahan.forEach { bahan ->
                Text(
                    text = "• $bahan",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Cara Memasak",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))

            resep.langkahLangkah.forEachIndexed { index, langkah ->
                Text(
                    text = "${index + 1}. $langkah",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    ResepKitaTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            DetailScreen(
                resep = DataPalsu.daftarResep[0],
                onNavigateBack = {}
            )
        }
    }
}