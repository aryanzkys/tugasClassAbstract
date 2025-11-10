package rental;

public class Truk extends Kendaraan {
    private final double muatanMaks;

    public Truk(String id, String nama, double biayaHarian, boolean tersedia, double muatanMaks) {
        super(id, nama, biayaHarian, tersedia);
        if (muatanMaks <= 0) {
            throw new IllegalArgumentException("Muatan maksimum harus positif");
        }
        this.muatanMaks = muatanMaks;
    }

    public double getMuatanMaks() {
        return muatanMaks;
    }

    @Override
    protected double hitungBiayaTambahan() {
        return muatanMaks * 25_000;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("   Muatan Maksimum: " + muatanMaks + " ton");
    }
}
