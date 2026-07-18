package trade.model.abstractclass;

import trade.model.enums.Kategori;

public abstract class Item {
    private final String nama;
    private final double harga;
    private final int jumlah;
    private final Kategori kategori;

    public Item(String nama, double harga, int jumlah, Kategori kategori) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }
    
    public double getHargaJualKeseluruhan() {
        return harga * jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public abstract String toString();
}