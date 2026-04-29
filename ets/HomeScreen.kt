package com.example.resepkita

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.resepkita.ui.theme.ResepKitaTheme

val CokelatFilter = Color(0xFF54280d)

@Composable
fun HomeScreen(
    onResepClick: (Int) -> Unit,
    onTambahResepClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Semua") }

    val filteredResep = DataPalsu.daftarResep.filter { resep ->
        val cocokDenganSearch = resep.namaMakanan.contains(searchQuery, ignoreCase = true) ||
                resep.deskripsiSingkat.contains(searchQuery, ignoreCase = true)

        val cocokDenganKategori = if (selectedCategory == "Semua") {
            true
        } else {
            val adaDiJudul = resep.namaMakanan.contains(selectedCategory, ignoreCase = true)
            val adaDiDeskripsi = resep.deskripsiSingkat.contains(selectedCategory, ignoreCase = true)
            val adaDiBahan = resep.daftarBahan.any { bahan -> bahan.contains(selectedCategory, ignoreCase = true) }

            adaDiJudul || adaDiDeskripsi || adaDiBahan
        }

        cocokDenganSearch && cocokDenganKategori
    }

    Box(modifier = modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(width = 2.5.dp, color = CokelatFilter, shape = RoundedCornerShape(16.dp)),
                placeholder = { Text("Cari resep atau bahan (misal: ayam)...") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Ikon Cari", modifier = Modifier.size(28.dp))
                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent,
                    focusedLeadingIconColor = CokelatFilter, unfocusedLeadingIconColor = CokelatFilter,
                    focusedTextColor = Color.Black, unfocusedTextColor = Color.Black,
                    focusedPlaceholderColor = CokelatFilter, unfocusedPlaceholderColor = Color.Gray
                )
            )

            if (filteredResep.isEmpty()) {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Maaf, tidak ada resep untuk pencarian '$searchQuery'",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(32.dp)
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
                    contentPadding = PaddingValues(bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        AsyncImage(
                            model = R.drawable.banner_atas,
                            contentDescription = "Banner Atas",
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp).clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp).horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val categories = listOf("Semua", "Ayam", "Sapi", "Ikan")
                            val listWarnaKategori = listOf(Color(0xFFC4D6FF), Color(0xFFFFD9C4), Color(0xFFFFC4EC), Color(0xFFD7FFBA))

                            categories.forEachIndexed { index, category ->
                                val isSelected = selectedCategory == category
                                val warnaAsli = listWarnaKategori[index % listWarnaKategori.size]

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(if (isSelected) warnaAsli else warnaAsli.copy(alpha = 0.3f))
                                        .clickable { selectedCategory = category }
                                        .padding(horizontal = 20.dp, vertical = 10.dp)
                                ) {
                                    Text(
                                        text = category,
                                        color = if (isSelected) Color.Black else Color(0xFF666666),
                                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    }

                    items(filteredResep) { resep ->
                        ResepCard(resep = resep, onClick = { onResepClick(resep.id) })
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        AsyncImage(
                            model = R.drawable.banner_bawah,
                            contentDescription = "Akhir dari daftar",
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 32.dp),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = onTambahResepClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            containerColor = CokelatFilter,
            contentColor = Color.White
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Tambah Resep")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ResepKitaTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            HomeScreen(onResepClick = {}, onTambahResepClick = {})
        }
    }
}