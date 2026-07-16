package trade.model.entity;

public class Item {
    private final int harga;
    private final int jumlah;
    private final String nama;
    
    public Item(int harga, int jumlah, String nama) {
        this.harga = harga;
        this.jumlah = jumlah;
        this.nama = nama;
    }

    public int getHarga() {return harga;}
    public int getJumlah() {return jumlah;}
    public String getNama() {return nama;}

}
