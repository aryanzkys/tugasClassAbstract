package rental;

public class Motor extends Kendaraan {

    public Motor(String id, String nama, double biayaHarian, boolean tersedia) {
        super(id, nama, biayaHarian, tersedia);
    }

    @Override
    protected double hitungBiayaTambahan() {
        return 20_000;
    }
}
