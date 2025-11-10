package rental;

public class Motor extends Kendaraan {

    private boolean helmDisediakan;

    public Motor(String id, String nama, double biayaHarian, boolean tersedia) {
        super(id, nama, biayaHarian, tersedia);
        this.helmDisediakan = true; 
    }

    @Override
    protected double hitungBiayaTambahan() {
        
        return 20_000;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Jenis: Motor");
        super.tampilkanDetail();
        System.out.println("Helm disediakan: " + (helmDisediakan ? "Ya" : "Tidak"));
        System.out.println("--------------------------");
    }
}
