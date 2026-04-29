package com.example.resepkita
import androidx.compose.runtime.mutableStateListOf
//kerangka untuk satu resep
data class Resep(
    val id: Int,
    val namaMakanan: String,
    val deskripsiSingkat: String,
    val gambarId: Int,
    val daftarBahan: List<String>,
    val langkahLangkah: List<String>
)

object DataPalsu {
    val daftarResep = mutableStateListOf(
        Resep(
            id = 1,
            namaMakanan = "Ayam Goreng Rempah",
            deskripsiSingkat = "Ayam goreng ungkep kaya rempah tradisional yang digoreng hingga keemasan. Bumbunya meresap sempurna sampai ke dalam daging, disajikan dengan taburan bumbu lengkuas garing yang gurih dan beraroma kuat.",
            gambarId = R.drawable.ayam_goreng,
            daftarBahan = listOf(
                "500 gram daging ayam (potong sesuai selera)",
                "2 batang serai (memarkan)",
                "3 lembar daun salam",
                "4 lembar daun jeruk",
                "100 gram lengkuas (parut kasar untuk taburan krispi)",
                "5 siung bawang putih",
                "8 siung bawang merah",
                "2 ruas kunyit",
                "1 sdm ketumbar sangrai",
                "Garam dan kaldu jamur secukupnya",
                "Minyak goreng"
            ),
            langkahLangkah = listOf(
                "Haluskan bawang putih, bawang merah, kunyit, dan ketumbar.",
                "Tumis bumbu halus bersama serai, daun salam, daun jeruk, dan lengkuas parut hingga harum dan matang.",
                "Masukkan potongan ayam, aduk rata dengan bumbu, lalu tuangkan sedikit air.",
                "Ungkep ayam dengan api kecil hingga air menyusut dan bumbu meresap sempurna ke dalam daging." ,
                "Panaskan minyak, goreng ayam beserta sisa bumbu ungkepan (lengkuas parut) hingga berwarna kuning keemasan.",
                "Angkat, tiriskan, dan sajikan dengan taburan bumbu rempah garing di atasnya."
            )
        ),
        Resep(
            id = 2,
            namaMakanan = "Bakmi Goreng Sapi",
            deskripsiSingkat = "Bakmi goreng kenyal dengan irisan daging sapi empuk dan sayuran segar, dibalut bumbu kecap manis gurih dengan aroma tumisan lada yang menggugah selera.",
            gambarId = R.drawable.bakmi_goreng,
            daftarBahan = listOf(
                "200 gram mie telur kering (rebus setengah matang, tiriskan)",
                "150 gram daging sapi (iris tipis memanjang)",
                "1 ikat sawi hijau (potong-potong)",
                "50 gram kol (iris kasar)",
                "4 siung bawang putih (cincang halus)",
                "3 siung bawang merah (iris tipis)",
                "3 sdm kecap manis",
                "1 sdm saus tiram",
                "1 sdt lada putih bubuk",
                "1 batang daun bawang (iris halus)",
                "Garam dan kaldu sapi secukupnya",
                "Minyak untuk menumis"
            ),
            langkahLangkah = listOf(
                "Panaskan minyak, tumis bawang putih dan bawang merah hingga harum.",
                "Masukkan irisan daging sapi, masak dengan api besar hingga daging berubah warna dan empuk.",
                "Masukkan sawi hijau dan kol, tumis sebentar hingga sayuran sedikit layu.",
                "Masukkan mie telur rebus, lalu tambahkan kecap manis, saus tiram, lada, garam, dan kaldu sapi.",
                "Aduk cepat hingga semua bumbu merata dan meresap ke dalam mie.",
                "Taburkan daun bawang, aduk sebentar, lalu angkat dan sajikan selagi hangat."
            )
        ),
        Resep(
            id = 3,
            namaMakanan = "Nasi Gudeg Komplit",
            deskripsiSingkat = "Nasi putih pulen hangat yang disajikan dengan gudeg nangka muda manis legit, dilengkapi dengan sambal goreng krecek pedas gurih, dan telur pindang rebus.",
            gambarId = R.drawable.bakmi_goreng,
            daftarBahan = listOf(
                "2 piring nasi putih pulen",
                "300 gram nangka muda (rebus, potong kasar)",
                "100 gram krecek (kerupuk kulit sapi)",
                "2 butir telur ayam (rebus matang, kupas)",
                "500 ml santan kental",
                "100 gram gula merah (sisir halus)",
                "3 lembar daun jati (opsional, untuk menghasilkan warna merah gelap)",
                "6 siung bawang merah & 4 siung bawang putih (haluskan)",
                "1 sdm ketumbar & 4 butir kemiri (haluskan)",
                "2 ruas lengkuas & 3 lembar daun salam",
                "Cabai rawit merah utuh (untuk krecek)",
                "Garam secukupnya"
            ),
            langkahLangkah = listOf(
                "Siapkan panci, alasi dasarnya dengan daun jati. Masukkan nangka muda, telur rebus, bumbu halus, daun salam, lengkuas, dan gula merah.",
                "Tuangkan santan, lalu masak dengan api kecil selama beberapa jam hingga santan habis, nangka empuk, dan warnanya berubah menjadi kecokelatan.",
                "Di wajan terpisah, tumis sedikit bumbu halus, masukkan krecek, cabai rawit utuh, dan sedikit santan. Masak hingga krecek lunak dan bumbu meresap.",
                "Siapkan piring, tuang nasi putih hangat.",
                "Tata gudeg nangka, telur pindang, dan sambal goreng krecek di atas nasi. Sajikan."
            )
        ),
        Resep(
            id = 4,
            namaMakanan = "Mie Ayam Bakwan",
            deskripsiSingkat = "Semangkuk mie kenyal dengan topping ayam kecap manis gurih, rebusan sawi hijau segar, ditaburi daun bawang, dan disempurnakan dengan tambahan bakwan renyah.",
            gambarId = R.drawable.gudeg,
            daftarBahan = listOf(
                "2 porsi mie basah/mie telur",
                "250 gram daging ayam fillet (potong dadu kecil)",
                "1 ikat sawi hijau (potong dan rebus sebentar)",
                "2 buah bakwan sayur goreng (potong menjadi beberapa bagian)",
                "4 siung bawang putih & 3 siung bawang merah (haluskan)",
                "1 ruas jahe (memarkan)",
                "4 sdm kecap manis & 1 sdm kecap asin",
                "Minyak ayam atau minyak wijen (untuk bumbu mangkuk)",
                "Daun bawang secukupnya (iris tipis)",
                "Garam, lada, dan kaldu jamur"
            ),
            langkahLangkah = listOf(
                "Buat topping ayam: Tumis bumbu halus dan jahe hingga harum. Masukkan potongan ayam, aduk hingga berubah warna.",
                "Tambahkan kecap manis, kecap asin, lada, garam, dan sedikit air. Masak hingga kuah mengental dan bumbu meresap ke ayam.",
                "Siapkan mangkuk, tuang 1 sendok makan minyak ayam/minyak wijen dan sedikit kecap asin.",
                "Rebus mie hingga matang dan kenyal, lalu tiriskan dan masukkan ke dalam mangkuk berisi bumbu. Aduk rata.",
                "Susun sawi hijau rebus di atas mie, lalu tuangkan ayam kecap beserta kuahnya.",
                "Beri potongan bakwan goreng di pinggir mangkuk dan taburi dengan daun bawang."
            )
        ),
        Resep(
            id = 5,
            namaMakanan = "Nasi Goreng Udang",
            deskripsiSingkat = "Nasi goreng seafood ala restoran dengan paduan udang kupas kenyal, sayuran segar, dan orak-arik telur, dimasak dengan api besar untuk aroma smoky yang khas.",
            gambarId = R.drawable.nasi_goreng,
            daftarBahan = listOf(
                "2 porsi nasi putih (sebaiknya nasi sisa semalam agar tidak lembek)",
                "100 gram udang kupas (bersihkan punggungnya)",
                "2 butir telur ayam",
                "1 buah wortel (potong dadu kecil, rebus sebentar)",
                "3 sdm kacang polong",
                "3 siung bawang putih (geprek dan cincang halus)",
                "2 siung bawang merah (cincang halus)",
                "2 sdm kecap manis",
                "1 sdm kecap ikan",
                "1 sdt saus tiram",
                "Garam, lada, dan kaldu bubuk",
                "Margarin atau minyak untuk menumis"
            ),
            langkahLangkah = listOf(
                "Panaskan sedikit minyak di wajan, buat orak-arik telur, lalu sisihkan di pinggir wajan.",
                "Tambahkan sedikit margarin, tumis bawang putih dan bawang merah hingga harum.",
                "Masukkan udang kupas, masak sebentar hingga udang berubah warna menjadi kemerahan.",
                "Masukkan wortel dan kacang polong, aduk rata dengan udang dan telur.",
                "Masukkan nasi putih. Tambahkan kecap manis, kecap ikan, saus tiram, lada, garam, dan kaldu bubuk.",
                "Besarkan api, aduk terus dengan cepat hingga nasi tercampur rata dengan bumbu dan sedikit mengering (smoky). Angkat dan sajikan hangat."
            )
        ),
        Resep(
            id = 6,
            namaMakanan = "Nasi Uduk Komplit",
            deskripsiSingkat = "Nasi uduk gurih beraroma santan dan serai yang menggugah selera. Disajikan lengkap dengan lauk daging sapi bumbu semur yang empuk, mie goreng kampung, dan irisan timun segar untuk menyeimbangkan rasa.",
            gambarId = R.drawable.nasi_uduk,
            daftarBahan = listOf(
                "300 gram beras",
                "400 ml santan",
                "2 batang serai (memarkan)",
                "2 lembar daun salam",
                "1 ruas lengkuas",
                "1 sdt garam",
                "250 gram daging sapi (potong tipis)",
                "4 sdm kecap manis",
                "3 siung bawang putih",
                "5 siung bawang merah",
                "pala bubuk",
                "garam",
                "lada",
                "1 keping mie telur (rebus)",
                "2 siung bawang putih (cincang)",
                "irisan kol",
                "2 sdm kecap manis",
                "1 buah timun (iris serong)",
                "bawang merah goreng untuk taburan"
            ),
            langkahLangkah = listOf(
                "Masak beras di dalam rice cooker bersama santan, serai, daun salam, lengkuas, dan garam.",
                "Aduk sesekali agar santan merata dan masak hingga matang.",
                "Tumis bumbu halus hingga harum. Masukkan daging sapi, kecap manis, pala, lada, dan air. Masak dengan api kecil hingga daging empuk dan kuah mengental.",
                "Tumis bawang putih, masukkan kol dan mie rebus.",
                "Tambahkan kecap manis dan penyedap, aduk rata hingga matang.",
                "Cetak nasi uduk di atas piring, susun semur daging sapi dan mie goreng di sampingnya. Beri irisan timun segar dan taburi dengan bawang merah goreng."
            )
        ),
        Resep(
            id = 7,
            namaMakanan = "Opor Ayam Kuah Kuning",
            deskripsiSingkat = "Potongan ayam empuk yang dimasak perlahan di dalam kuah santan kuning kental yang kaya rempah. Rasanya sangat gurih, beraroma rempah sangrai yang khas, dan tekstur dagingnya sangat lembut (hanya lauk, tanpa nasi).",
            gambarId = R.drawable.opor_ayam,
            daftarBahan = listOf(
                "500 gram ayam (potong sesuai selera, cuci bersih)",
                "600 ml santan encer & 200 ml santan kental",
                "2 batang serai (memarkan)",
                "3 lembar daun jeruk & 2 lembar daun salam",
                "1 ruas lengkuas (memarkan)",
                "7 siung bawang merah", "4 siung bawang putih", "4 butir kemiri (sangrai)", "2 ruas kunyit (bakar sebentar)", "1 sdt ketumbar", "1/2 sdt jintan", "merica", "dan garam.",
                "Bawang merah goreng (untuk taburan)"
            ),
            langkahLangkah = listOf(
                "Panaskan sedikit minyak, tumis bumbu halus bersama serai, daun salam, daun jeruk, dan lengkuas hingga matang dan wangi.",
                "Masukkan potongan ayam, aduk rata hingga ayam berubah warna.",
                "Tuangkan santan encer. Masak dengan api sedang hingga ayam empuk dan bumbu meresap.",
                "Setelah ayam empuk, kecilkan api lalu tuangkan santan kental. Beri garam, gula, dan penyedap.",
                "Aduk perlahan agar santan tidak pecah. Masak hingga mendidih kembali dan kuah sedikit menyusut.",
                "Angkat, pindahkan ke mangkuk saji, dan taburi dengan bawang merah goreng."
            )
        ),
        Resep(
            id = 8,
            namaMakanan = "Pecel Lele Sambel Terasi",
            deskripsiSingkat = "Ikan lele goreng yang renyah di luar namun lembut di dalam. Disajikan segar dengan bumbu sambal terasi tomat yang pedas manis, lengkap dengan aneka lalapan sayur mentah yang renyah (hanya lauk, tanpa nasi).",
            gambarId = R.drawable.pecel_lele,
            daftarBahan = listOf(
                "3 ekor ikan lele ukuran sedang (bersihkan, kerat-kerat badannya)",
                "3 siung bawang putih", "1 sdt ketumbar bubuk", "1 ruas kunyit", "1 sdt garam", "perasan jeruk nipis (haluskan dan beri sedikit air)",
                "2 buah tomat merah ukuran sedang", "10 buah cabai rawit (sesuai selera)", "3 buah cabai merah keriting", "4 siung bawang merah", "1 sdt terasi bakar", "1 sdt gula merah", "garam",
                "Daun kemangi", "irisan timun", "kol krispi (kol mentah segar)", "kacang panjang"
            ),
            langkahLangkah = listOf(
                "Rendam lele dalam bumbu marinasi selama 15-20 menit agar bumbu meresap hingga ke dalam daging dan menghilangkan bau amis.",
                "Panaskan minyak yang cukup banyak. Goreng lele hingga kuning keemasan dan tekstur luarnya kering krispi. Angkat dan tiriskan.",
                "Goreng cabai, bawang merah, dan tomat hingga layu. Angkat, lalu ulek bersama terasi, gula merah, dan garam hingga halus. Beri perasan sedikit jeruk limau agar segar.",
                "Siapkan piring lebar, letakkan lele goreng berdampingan dengan ulekan sambal terasi.",
                "Tata lalapan kemangi, timun, kol, dan kacang panjang di sekelilingnya."
            )
        ),
        Resep(
            id = 9,
            namaMakanan = "Pepes Ikan Kemangi",
            deskripsiSingkat = "Olahan ikan segar yang dilumuri bumbu rempah kuning yang sangat melimpah, lalu dibungkus daun pisang dan dikukus hingga matang. Menghasilkan rasa gurih yang sehat tanpa minyak, dengan letupan aroma daun kemangi yang luar biasa wangi (hanya lauk, tanpa nasi).",
            gambarId = R.drawable.pepes_ikan,
            daftarBahan = listOf(
                "2 ekor ikan ukuran sedang (bisa ikan nila, mas, atau kembung), cuci bersih dan lumuri jeruk nipis.",
                "2 ikat daun kemangi (petik daunnya)",
                "2 buah tomat (iris kasar)",
                "4 lembar daun salam",
                "2 batang serai (iris serong tipis)",
                "Daun pisang secukupnya (layukan di atas api kompor) & lidi/tusuk gigi.",
                "8 siung bawang merah", "4 siung bawang putih", "4 buah kemiri", "2 ruas kunyit", "1 ruas jahe", "5 buah cabai merah keriting", "cabai rawit utuh (opsional)", "garam", "gula pasir."
            ),
            langkahLangkah = listOf(
                "Campurkan bumbu halus dengan daun kemangi, irisan tomat, dan irisan serai di dalam satu wadah.",
                "Masukkan ikan ke dalam wadah bumbu, lumuri seluruh bagian ikan dengan bumbu hingga ke bagian dalam perutnya.",
                "Siapkan selembar daun pisang. Letakkan daun salam di dasarnya, lalu taruh ikan beserta bumbunya yang melimpah di atas daun salam.",
                "Gulung daun pisang dengan rapi, lalu sematkan lidi atau tusuk gigi di kedua ujungnya.",
                "Panaskan panci pengukus. Kukus pepes ikan selama kurang lebih 30-45 menit hingga ikan matang sempurna.",
                "(Opsional) Bakar sebentar bungkusan pepes di atas teflon agar aroma daun pisangnya makin keluar. Angkat dan sajikan hangat."
            )
        ),
        Resep(
            id = 10,
            namaMakanan = "Pindang Ikan Segar",
            deskripsiSingkat = "Sajian ikan berkuah bening yang sangat menyegarkan dengan paduan rasa asam, manis, dan pedas yang seimbang. Aromanya sangat wangi berkat potongan nanas segar dan daun kemangi, sangat cocok dinikmati hangat-hangat sebagai lauk berkuah (tanpa nasi).",
            gambarId = R.drawable.pindang,
            daftarBahan = listOf(
                "500 gram ikan patin atau bandeng (potong, cuci bersih, lumuri jeruk nipis)",
                "1/2 buah nanas matang (potong kipas)",
                "1 ikat daun kemangi (petik daunnya)",
                "2 buah tomat merah (potong kasar)",
                "2 batang serai (memarkan)",
                "3 lembar daun salam",
                "1 ruas lengkuas",
                "1 ruas jahe (memarkan)",
                "1 sdm air asam jawa pekat",
                "6 siung bawang merah", "3 siung bawang putih", "5 buah cabai merah keriting", "cabai rawit utuh sesuai selera", "1 ruas kunyit (iris tipis)",
                "Kecap manis", "garam", "sedikit gula merah"
            ),
            langkahLangkah = listOf(
                "Didihkan air di dalam panci. Setelah mendidih, masukkan semua bumbu iris, serai, daun salam, lengkuas, dan jahe. Rebus hingga kuah harum.",
                "Masukkan air asam jawa, kecap manis, garam, dan gula merah. Aduk rata dan koreksi rasa kuahnya.",
                "Masukkan potongan ikan. Masak dengan api sedang (jangan terlalu sering diaduk agar ikan tidak hancur).",
                "Saat ikan hampir matang, masukkan potongan nanas, tomat, dan cabai rawit utuh.",
                "Sesaat sebelum kompor dimatikan, taburkan daun kemangi. Angkat dan sajikan selagi kuahnya panas dan wangi."
            )
        ),
        Resep(
            id = 11,
            namaMakanan = "Rawon Daging",
            deskripsiSingkat = "Sup daging sapi berkuah hitam pekat khas Jawa Timur yang rasanya sangat gurih dan kaya rempah dari buah kluwek. Disajikan lengkap bersama nasi putih hangat, tauge pendek yang renyah, dan telur asin masir.",
            gambarId = R.drawable.rawon,
            daftarBahan = listOf(
                "2 porsi nasi putih hangat",
                "500 gram daging sapi berlemak (sandung lamur), potong dadu",
                "4 buah kluwek (pecahkan, ambil daging buahnya, rendam air panas sebentar)",
                "2 batang serai (memarkan) & 4 lembar daun jeruk",
                "2 batang daun bawang (iris kasar)",
                "8 siung bawang merah", "4 siung bawang putih", "1 sdt ketumbar sangrai", "1 ruas kunyit", "1 ruas jahe", "sejumput jintan", "garam",
                "Tauge pendek (kecambah rawon)", "setengah butir telur asin rebus", "sambal terasi", "kerupuk udang"
            ),
            langkahLangkah = listOf(
                "Rebus daging sapi dengan air secukupnya hingga setengah empuk. Jangan buang air rebusannya (kaldu).",
                "Haluskan semua bumbu halus beserta daging buah kluwek hingga benar-benar menyatu dan hitam pekat.",
                "Panaskan sedikit minyak, tumis bumbu halus bersama serai dan daun jeruk hingga bumbu matang, harum, dan tidak langu.",
                "Masukkan bumbu tumisan ke dalam panci rebusan daging. Aduk rata.",
                "Masak kembali dengan api kecil hingga bumbu meresap sempurna, daging sangat empuk, dan kuah sedikit berminyak. Masukkan irisan daun bawang.",
                "Siapkan piring, tuang nasi putih. Siram dengan rawon daging, taburi tauge pendek, dan sajikan dengan telur asin serta sambal."
            )
        ),
        Resep(
            id = 12,
            namaMakanan = "Rendang Daging Sapi",
            deskripsiSingkat = "Olahan daging sapi legendaris asal Minang yang dimasak perlahan berjam-jam dalam balutan santan dan aneka rempah. Menghasilkan daging bertekstur empuk dengan bumbu cokelat gelap yang mengering dan meresap sempurna. Disajikan dengan nasi putih.",
            gambarId = R.drawable.rendang,
            daftarBahan = listOf(
                "2 porsi nasi putih hangat",
                "500 gram daging sapi (khas dalam/gandik), potong agak tebal searah serat",
                "1 liter santan kental & 500 ml santan encer (dari 2 butir kelapa)",
                "3 lembar daun jeruk, 2 lembar daun kunyit (ikat simpul), 2 batang serai (memarkan)",
                "1 buah asam kandis",
                "2 sdm kelapa sangrai tumbuk (kelapa gongseng/ambubu)",
                "10 siung bawang merah", "5 siung bawang putih", "100 gram cabai merah keriting", "1 ruas lengkuas", "1 ruas jahe", "1 sdm ketumbar", "pala", "garam"
            ),
            langkahLangkah = listOf(
                "Siapkan wajan besar. Masukkan santan encer, bumbu halus, daun jeruk, daun kunyit, serai, dan asam kandis. Rebus sambil terus diaduk perlahan agar santan tidak pecah.",
                "Setelah mendidih dan wangi, masukkan potongan daging sapi. Masak hingga santan encer menyusut.",
                "Tuangkan santan kental. Masak terus dengan api sedang cenderung kecil sambil sesekali diaduk dari dasar wajan agar tidak gosong.",
                "Saat kuah mulai mengental, masukkan kelapa sangrai (ambubu).",
                "Lanjutkan proses memasak (mengaduk) dengan api kecil hingga kuah santan berubah warna menjadi kecokelatan, mengeluarkan minyak, dan akhirnya mengering menempel pada daging.",
                "Angkat dan sajikan di atas piring bersama nasi putih hangat."
            )
        )
    )
}