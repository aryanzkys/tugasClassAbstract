package rental;

public abstract class Kendaraan {
    private final String id;
    private final String nama;
    private final double biayaHarian;
    private boolean tersedia;

    protected Kendaraan(String id, String nama, double biayaHarian, boolean tersedia) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID kendaraan tidak boleh kosong");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama kendaraan tidak boleh kosong");
        }
        if (biayaHarian <= 0) {
            throw new IllegalArgumentException("Biaya harian harus lebih dari 0");
        }
        this.id = id;
        this.nama = nama;
        this.biayaHarian = biayaHarian;
        this.tersedia = tersedia;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getBiayaHarian() {
        return biayaHarian;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public double hitungBiayaTotal(int hari) {
        if (hari <= 0) {
            throw new IllegalArgumentException("Hari sewa harus lebih dari 0");
        }
        if (hari > 7) {
            throw new IllegalArgumentException("Hari sewa maksimal 7 hari");
        }
        return (biayaHarian * hari) + hitungBiayaTambahan();
    }

    public void tampilkanDetail() {
        System.out.println("ID: " + id + ", Nama: " + nama + ", Biaya Harian: Rp "
                + String.format("%,.0f", biayaHarian) + ", Status: " + (tersedia ? "Tersedia" : "Tidak Tersedia"));
    }

    protected abstract double hitungBiayaTambahan();
}
