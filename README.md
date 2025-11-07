# Sistem Rental Kendaraan

Repositori ini merupakan studi kasus untuk mengenalkan konsep *abstract class* pada Java melalui simulasi sistem rental kendaraan. Kami diminta untuk mengimplementasikan kelas abstrak `Kendaraan`, tiga subclass konkret (`Mobil`, `Motor`, `Truk`), serta antarmuka konsol sederhana yang menampilkan polymorphism secara praktis.

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
- **Implementasi dasar** hanya memakai kelas bawaan (`java.util.Scanner`, `java.util.ArrayList`).

> **Catatan asumsi biaya tambahan**: Biaya tambahan diterapkan satu kali per transaksi (tidak bergantung pada jumlah hari) sesuai kerangka abstract method yang disediakan pada lembar studi kasus 2.

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

- Menyimpan data inventaris dari file atau database sederhana agar lebih praktis.
- Menambahkan menu untuk mengembalikan kendaraan (`setTersedia(true)`).
- Memperluas tipe kendaraan atau membuat variasi perhitungan biaya tambahan.
- Menggunakan unit test (misal JUnit) untuk memastikan perhitungan biaya berjalan benar.

## Kontributor

- Muhammad Hafiizh Anindya (255150207111057) - merancang abstract class `Kendaraan` dan logika validasi dasar.
- Ulfa Aulia Sakina (255150207111058) - mengimplementasikan subclass `Mobil` beserta aturan biaya tambahan.
- Aryan Zaky Prayogo (255150207111059) - menyusun kelas `Main`, menu interaktif, dan koordinasi integrasi.
- Faeyza Safa Izz Deyardi (255150207111060) - mengembangkan subclass `Motor` dan pengujian biaya sewa.
- Raven Ravellyn Sulistyo (255150207111061) - mengimplementasikan subclass `Truk` serta dokumentasi teknis awal.
- Jaler Zuhdi Nail (255150207111062) - melakukan pengujian keseluruhan alur dan perapihan dokumentasi.
