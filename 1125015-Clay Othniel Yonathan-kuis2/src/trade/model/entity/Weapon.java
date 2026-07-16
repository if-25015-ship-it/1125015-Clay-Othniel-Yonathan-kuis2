package trade.model.entity;

public class Weapon extends Item {
    int atkValue;
    String weaponType;
    public Weapon(int harga, int jumlah, String nama, int atkValue, String weaponType) {
        super(harga, 1, nama);
        this.atkValue = atkValue;
        this.weaponType = weaponType;
    }
    public int getAtkValue() {return atkValue;}
    public String getWeaponType() {return weaponType;}
}