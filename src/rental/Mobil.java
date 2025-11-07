package rental;

public class Mobil extends Kendaraan {
    private final boolean bensin;

    public Mobil(String id, String nama, double biayaHarian, boolean tersedia, boolean bensin) {
        super(id, nama, biayaHarian, tersedia);
        this.bensin = bensin;
    }

    public boolean isBensin() {
        return bensin;
    }

    @Override
    protected double hitungBiayaTambahan() {
        return bensin ? getBiayaHarian() * 0.1 : 0;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("   Tipe Bahan Bakar: " + (bensin ? "Bensin" : "Non-bensin"));
    }
}
