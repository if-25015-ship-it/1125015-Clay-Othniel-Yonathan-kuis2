package trade.model.entity;

public class Armor extends Item {
    int defValue;
    String armorType;
    public Armor(int harga, int jumlah, String nama, int defValue, String armorType) {
        super(harga, 1, nama);
        this.defValue = defValue;
        this.armorType = armorType;
    }
    public int getDefValue() {return defValue;}
    public String getArmorType() {return armorType;}
}