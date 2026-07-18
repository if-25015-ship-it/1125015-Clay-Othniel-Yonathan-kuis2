package trade.model.entity;

import trade.model.abstractclass.Item;
import trade.model.enums.Kategori;
import trade.model.enums.ArmorType;

public class Armor extends Item {
    int defValue;
    ArmorType armorType;
    public Armor(String nama, double harga, int defValue, ArmorType armorType) {
        super(nama, harga, 1, Kategori.ARMOR);
        this.defValue = defValue;
        this.armorType = armorType;
    }
    public int getDefValue() {return defValue;}
    public ArmorType getArmorType() {return armorType;}

    @Override
    public String toString() {
        return String.format("%s (Armor [%s] DEF %d), total unit 1, total harga %.1f", 
                getNama(), armorType, defValue, getHargaJualKeseluruhan());
    }
}