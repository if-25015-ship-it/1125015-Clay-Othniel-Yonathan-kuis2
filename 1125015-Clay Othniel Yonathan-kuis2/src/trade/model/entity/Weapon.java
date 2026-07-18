package trade.model.entity;

import trade.model.abstractclass.Item;
import trade.model.enums.Kategori;
import trade.model.enums.WeaponType;

public class Weapon extends Item {
    int atkValue;
    WeaponType weaponType;
    public Weapon(String nama, double harga, int atkValue, WeaponType weaponType) {
        super(nama, harga, 1, Kategori.WEAPON);
        this.atkValue = atkValue;
        this.weaponType = weaponType;
    }
    public int getAtkValue() {return atkValue;}
    public WeaponType getWeaponType() {return weaponType;}

    @Override
    public String toString() {
        return String.format("%s (Weapon [%s] ATK %d), total unit 1, total harga %.1f", 
                getNama(), weaponType, atkValue, getHarga());
    }
}