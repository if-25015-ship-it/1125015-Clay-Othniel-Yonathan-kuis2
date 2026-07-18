package trade.model.entity;

import trade.model.abstractclass.Item;
import trade.model.enums.Kategori;

public class Potion extends Item {
    int hpRestore;
    int manaRestore;
    public Potion( String nama, double harga, int jumlah, int hpRestore, int manaRestore) {
        super(nama, harga, jumlah, Kategori.POTION);
        this.hpRestore = hpRestore;
        this.manaRestore = manaRestore;
    }
    public int getHpRestore() {return hpRestore;}
    public int getManaRestore() {return manaRestore;}

    @Override
    public String toString() {
        return String.format("%s (HP +%d, MP +%d), total unit %d, total harga %.1f", 
                getNama(), hpRestore, manaRestore, getJumlah(), getHarga());
    }
}