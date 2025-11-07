# Sistem Rental Kendaraan

Repositori ini merupakan studi kasus untuk mengenalkan konsep *abstract class* pada Java melalui simulasi sistem rental kendaraan. Mahasiswa diminta untuk mengimplementasikan kelas abstrak `Kendaraan`, tiga subclass konkret (`Mobil`, `Motor`, `Truk`), serta antarmuka konsol sederhana yang menampilkan polymorphism secara praktis.

## Struktur Proyek

```
src/
  rental/
    Kendaraan.java    // Abstract class sebagai kerangka utama kendaraan
    Mobil.java        // Implementasi kendaraan mobil
    Motor.java        // Implementasi kendaraan motor
    Truk.java         // Implementasi kendaraan truk
    Main.java         // Menu dan alur aplikasi konsol
```

## Fitur Utama

- **Abstract class `Kendaraan`** menyimpan data umum (ID, nama, biaya harian, status) dan memaksa subclass menyediakan perhitungan biaya tambahan melalui method abstrak `hitungBiayaTambahan()`.
- **Polymorphism** dimanfaatkan saat menghitung biaya sewa dan menampilkan detail, sehingga `Main` dapat bekerja dengan koleksi `ArrayList<Kendaraan>` tanpa mengetahui tipe spesifik objek.
- **Menu konsol** menyediakan opsi untuk menampilkan inventaris, menghitung biaya sewa (1-7 hari), mencari kendaraan yang tersedia berdasar jenis, serta memperbarui status setelah kendaraan disewa.
- **Validasi input** diterapkan untuk menangani ID yang tidak ditemukan, hari sewa di luar rentang, serta format masukan non-numerik.
- **Implementasi dasar** hanya memakai kelas bawaan (`java.util.Scanner`, `java.util.ArrayList`) sehingga tetap ramah untuk latihan semester awal.

> **Catatan asumsi biaya tambahan**: Biaya tambahan diterapkan satu kali per transaksi (tidak bergantung pada jumlah hari) sesuai kerangka abstract method yang disediakan pada lembar studi kasus.

## Menjalankan Program

1. Pastikan Java 8 atau lebih baru sudah terpasang (`java -version`).
2. Kompilasi seluruh berkas sumber:
   ```powershell
   javac -d out src/rental/*.java
   ```
3. Jalankan aplikasi dari folder `out`:
   ```powershell
   java -cp out rental.Main
   ```

## Ide Pengembangan Lanjutan

- Menyimpan data inventaris dari file eksternal atau basis data sederhana.
- Menambahkan menu untuk mengembalikan kendaraan (`setTersedia(true)`).
- Memperluas hierarki dengan tipe kendaraan lain atau strategi biaya tambahan berbeda.
- Menggunakan *unit test* (mis. JUnit) untuk memverifikasi logika perhitungan biaya.

Selamat belajar dan bereksperimen dengan konsep abstract class dalam konteks yang lebih nyata!
