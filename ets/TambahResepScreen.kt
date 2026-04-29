package com.example.resepkita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahResepScreen(
    onSimpanSukses: () -> Unit,
    modifier: Modifier = Modifier
) {
    var judul by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var bahan by remember { mutableStateOf("") }
    var langkah by remember { mutableStateOf("") }

    val cokelatFilter = Color(0xFF54280d)

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Tambah Resep Baru",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = cokelatFilter
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = judul,
            onValueChange = { judul = it },
            label = { Text("Nama Makanan") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = deskripsi,
            onValueChange = { deskripsi = it },
            label = { Text("Deskripsi Singkat") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = bahan,
            onValueChange = { bahan = it },
            label = { Text("Daftar Bahan (Pisahkan dengan Enter)") },
            placeholder = { Text("Contoh:\n2 siung bawang\n1 ekor ayam") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 4
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = langkah,
            onValueChange = { langkah = it },
            label = { Text("Langkah-langkah (Pisahkan dengan Enter)") },
            placeholder = { Text("Contoh:\n1. Cuci ayam\n2. Goreng ayam") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 4
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val daftarBahanList = bahan.split("\n").filter { it.isNotBlank() }
                val langkahLangkahList = langkah.split("\n").filter { it.isNotBlank() }

                val resepBaru = Resep(
                    id = if (DataPalsu.daftarResep.isEmpty()) 1 else DataPalsu.daftarResep.maxOf { it.id } + 1,
                    namaMakanan = judul,
                    deskripsiSingkat = deskripsi,
                    gambarId = R.drawable.banner_atas, // Sementara pakai gambar default
                    daftarBahan = daftarBahanList.ifEmpty { listOf("Tidak ada bahan") },
                    langkahLangkah = langkahLangkahList.ifEmpty { listOf("Tidak ada langkah") }
                )

                DataPalsu.daftarResep.add(resepBaru)
                onSimpanSukses()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = cokelatFilter)
        ) {
            Text("Simpan Resep", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}