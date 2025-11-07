package rental;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final ArrayList<Kendaraan> INVENTARIS = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiInventaris();
        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenu();
            String pilihan = bacaTeks("Pilih menu: ");
            switch (pilihan) {
                case "1":
                    tampilkanSemuaKendaraan();
                    break;
                case "2":
                    hitungBiayaSewa();
                    break;
                case "3":
                    cariKendaraanTersedia();
                    break;
                case "0":
                    berjalan = false;
                    System.out.println("Terima kasih, sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal. Silakan coba lagi.");
            }
        }
        INPUT.close();
    }

    private static void tampilkanMenu() {
        System.out.println();
        System.out.println("==== Sistem Rental Kendaraan ====");
        System.out.println("1. Tampilkan semua kendaraan");
        System.out.println("2. Hitung biaya sewa kendaraan");
        System.out.println("3. Cari kendaraan tersedia berdasarkan jenis");
        System.out.println("0. Keluar");
    }

    private static void tampilkanSemuaKendaraan() {
        System.out.println("\n-- Daftar Kendaraan --");
        for (Kendaraan kendaraan : INVENTARIS) {
            kendaraan.tampilkanDetail();
        }
    }

    private static void hitungBiayaSewa() {
        String id = bacaTeks("Masukkan ID kendaraan: ");
        Kendaraan kendaraan = cariKendaraanById(id);
        if (kendaraan == null) {
            System.out.println("Kendaraan dengan ID " + id + " tidak ditemukan.");
            return;
        }
        try {
            int hari = bacaBilangan("Masukkan jumlah hari sewa (1-7): ");
            double total = kendaraan.hitungBiayaTotal(hari);
            System.out.println("Biaya total untuk " + kendaraan.getNama() + " ID: " + kendaraan.getId()
                    + " selama " + hari + " hari: " + formatRupiah(total));

            if (kendaraan.isTersedia()) {
                String konfirmasi = bacaTeks("Update status menjadi tidak tersedia? (y/n): ");
                if (konfirmasi.equalsIgnoreCase("y")) {
                    kendaraan.setTersedia(false);
                    System.out.println("Status kendaraan diperbarui menjadi tidak tersedia.");
                }
            } else {
                System.out.println("Catatan: kendaraan saat ini tidak tersedia.");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
        }
    }

    private static void cariKendaraanTersedia() {
        String jenis = bacaTeks("Masukkan jenis kendaraan (Mobil/Motor/Truk): ");
        String jenisLower = jenis.trim().toLowerCase();
        boolean ditemukan = false;

        for (Kendaraan kendaraan : INVENTARIS) {
            if (kendaraan.isTersedia() && cocokJenis(kendaraan, jenisLower)) {
                kendaraan.tampilkanDetail();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada kendaraan tersedia untuk jenis: " + jenis);
        }
    }

    private static boolean cocokJenis(Kendaraan kendaraan, String jenisLower) {
        switch (jenisLower) {
            case "mobil":
                return kendaraan instanceof Mobil;
            case "motor":
                return kendaraan instanceof Motor;
            case "truk":
            case "truck":
                return kendaraan instanceof Truk;
            default:
                return false;
        }
    }

    private static String bacaTeks(String prompt) {
        System.out.print(prompt);
        return INPUT.nextLine().trim();
    }

    private static int bacaBilangan(String prompt) {
        while (true) {
            String masukan = bacaTeks(prompt);
            try {
                return Integer.parseInt(masukan);
            } catch (NumberFormatException ex) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }
    }

    private static Kendaraan cariKendaraanById(String id) {
        for (Kendaraan kendaraan : INVENTARIS) {
            if (kendaraan.getId().equalsIgnoreCase(id)) {
                return kendaraan;
            }
        }
        return null;
    }

    private static void inisialisasiInventaris() {
        INVENTARIS.add(new Mobil("MBL001", "Toyota Avanza", 350_000, true, true));
        INVENTARIS.add(new Mobil("MBL002", "Daihatsu Terios", 375_000, true, false));
        INVENTARIS.add(new Motor("MTR101", "Honda Beat", 90_000, true));
        INVENTARIS.add(new Motor("MTR102", "Yamaha NMAX", 120_000, false));
        INVENTARIS.add(new Truk("TRK55", "Hino Dutro", 500_000, true, 4));
    }

    private static String formatRupiah(double angka) {
        long pembulatan = Math.round(angka);
        return "Rp " + pembulatan;
    }
}
