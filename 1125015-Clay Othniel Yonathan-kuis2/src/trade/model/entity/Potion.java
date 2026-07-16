package trade.model.entity;

public class Potion extends Item {
    int hpRestore;
    int manaRestore;
    public Potion(int harga, int jumlah, String nama, int hpRestore, int manaRestore) {
        super(harga, jumlah, nama);
        this.hpRestore = hpRestore;
        this.manaRestore = manaRestore;
    }
    public int getHpRestore() {return hpRestore;}
    public int getManaRestore() {return manaRestore;}
}