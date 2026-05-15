package com.example.loginmvvmappbaru.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginmvvmappbaru.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // --- MENDEFINISIKAN SKEMA WARNA ---
    val primaryColor = Color(0xFF6200EE) // Ungu tema utama
    val successBackgroundColor = Color(0xFFE8F5E9) // Hijau terang untuk latar belakang sukses
    val successContentColor = Color(0xFF2E7D32) // Hijau tua untuk konten sukses
    val failureBackgroundColor = Color(0xFFFFEBEE) // Merah terang untuk latar belakang gagal
    val failureContentColor = Color(0xFFD32F2F) // Merah tua untuk konten gagal

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // --- BAGIAN ATAS: CARD USER LOGIN DENGAN IKON GEMBOK BESAR ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = primaryColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Lock Icon",
                    tint = Color.White,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "User Login",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Silakan masukkan username dan password",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }

        // --- BAGIAN TENGAH: INPUT FIELDS DENGAN IKON AWALAN (LEADING ICONS) ---
        // Kolom Username dengan Ikon Orang
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Person Icon")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Kolom Password dengan Ikon Kunci
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")
            },
            visualTransformation = PasswordVisualTransformation(), // MENYEMBUNYIKAN PASSWORD
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // --- BAGIAN BAWAH: TOMBOL LOGIN YANG BERGAYA ---
        Button(
            onClick = { viewModel.login(username, password) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text(text = "LOGIN", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- BAGIAN KUNCI: UMPAN BALIK VISUAL DINAMIS (CARD SUKSES/GAGAL) ---
        // Logika untuk menentukan warna berdasarkan teks status dari ViewModel
        val statusColorInfo = when {
            viewModel.loginState.contains("Berhasil") -> {
                Triple(successBackgroundColor, successContentColor, Icons.Default.CheckCircle)
            }
            viewModel.loginState.contains("Salah") -> {
                Triple(failureBackgroundColor, failureContentColor, Icons.Default.Warning)
            }
            else -> null // Jangan tampilkan apa pun jika status kosong
        }

        // Menampilkan Card umpan balik visual hanya jika statusColorInfo tidak null
        statusColorInfo?.let { (bgColor, contentColor, iconVector) ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = bgColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = "Status Icon",
                        tint = contentColor,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        val statusTitle = if (contentColor == successContentColor) "Login Berhasil" else "Login Gagal"
                        Text(
                            text = statusTitle,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = contentColor
                        )
                        Text(
                            text = viewModel.loginState, // Menampilkan pesan status detail dari ViewModel
                            fontSize = 14.sp,
                            color = contentColor.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
    }
}