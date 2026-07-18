// File: src/trade/controller/TradeController.java
package trade.controller;

import trade.model.exception.EmptyListException;
import trade.model.exception.EmptyInputException;
import trade.model.exception.InvalidNumberException;
import trade.model.abstractclass.Item;
import trade.model.entity.Potion;
import trade.model.entity.Weapon;
import trade.model.entity.Armor;
import trade.model.enums.WeaponType;
import trade.model.enums.ArmorType;
import trade.util.CLIUtil;
import trade.util.ListUtil;
import trade.view.TradeView;

import java.util.ArrayList;
import java.util.List;

public class TradeController {
    // Kategori disimpan secara terpisah sesuai dengan spesifikasi soal
    private final List<Potion> daftarPotion = new ArrayList<>();
    private final List<Weapon> daftarWeapon = new ArrayList<>();
    private final List<Armor> daftarArmor = new ArrayList<>();
    private final TradeView view;

    public TradeController(TradeView view) {
        this.view = view;
    }

    public void start() {
        int pilihan = -1;
        while (pilihan != 0) {
            view.showMenu();
            try {
                pilihan = CLIUtil.getIntInput("Pilih menu: ");
                switch (pilihan) {
                    case 1:
                        tambahBarang();
                        break;
                    case 2:
                        displayListAll();
                        break;
                    case 3:
                        displayListSatuan();
                        break;
                    case 0:
                        view.printMessage("Exit");
                        break;
                    default:
                        view.printMessage("Pilihan menu tidak tersedia.");
                }
            } catch (EmptyInputException | InvalidNumberException e) {
                view.printError(e.getMessage());
            }
        }
    }

    private void tambahBarang() {
        try {
            view.printMessage("\n--- Kategori Barang ---");
            view.printMessage("1. Potion");
            view.printMessage("2. Weapon");
            view.printMessage("3. Armor");
            int choice = CLIUtil.getIntInput("Pilih Kategori [1-3]: ");

            String nama = CLIUtil.getStringInput("Masukkan nama barang: ");
            double hargaSatuan = CLIUtil.getDoubleInput("Masukkan harga satuan: ");

            switch (choice) {
                case 1:
                    int jumlahJual = CLIUtil.getIntInput("Masukkan jumlah jual keseluruhan: ");
                    int hpRestore = CLIUtil.getIntInput("Masukkan HP Restore value: ");
                    int manaRestore = CLIUtil.getIntInput("Masukkan Mana Restore value: ");
                    
                    Potion potion = new Potion(nama, hargaSatuan, jumlahJual, hpRestore, manaRestore);
                    daftarPotion.add(potion);
                    view.printMessage("Potion berhasil ditambahkan ke daftar.");
                    break;

                case 2:
                    int atk = CLIUtil.getIntInput("Masukkan Attack value: ");
                    view.printMessage("Pilih Tipe Weapon: 1. Sword, 2. Axe, 3. Spear, 4. Bow");
                    int typeWp = CLIUtil.getIntInput("Pilih [1-4]: ");
                    WeaponType weaponType;
                    switch (typeWp) {
                        case 1: weaponType = WeaponType.SWORD; break;
                        case 2: weaponType = WeaponType.AXE; break;
                        case 3: weaponType = WeaponType.SPEAR; break;
                        case 4: weaponType = WeaponType.BOW; break;
                        default:
                            throw new InvalidNumberException("Pilihan tipe Weapon tidak valid!");
                    }
                    
                    Weapon weapon = new Weapon(nama, hargaSatuan, atk, weaponType);
                    daftarWeapon.add(weapon);
                    view.printMessage("Weapon berhasil ditambahkan ke daftar.");
                    break;

                case 3:
                    int def = CLIUtil.getIntInput("Masukkan Defense value: ");
                    view.printMessage("Pilih Tipe Armor: 1. Heavy, 2. Medium, 3. Light");
                    int typeAr = CLIUtil.getIntInput("Pilih [1-3]: ");
                    ArmorType armorType;
                    switch (typeAr) {
                        case 1: armorType = ArmorType.HEAVY; break;
                        case 2: armorType = ArmorType.MEDIUM; break;
                        case 3: armorType = ArmorType.LIGHT; break;
                        default:
                            throw new InvalidNumberException("Pilihan tipe Armor tidak valid!");
                    }
                    
                    Armor armor = new Armor(nama, hargaSatuan, def, armorType);
                    daftarArmor.add(armor);
                    view.printMessage("Armor berhasil ditambahkan ke daftar.");
                    break;

                default:
                    view.printMessage("Kategori tidak dikenal!");
            }
        } catch (EmptyInputException | InvalidNumberException e) {
            view.printError(e.getMessage());
        }
    }

    private void displayListAll() {
        try {
            listEmpty();
            view.printMessage("\n--- Daftar Terurut Harga Keseluruhan Termurah ---");
            
            if (!daftarPotion.isEmpty()) {
                view.printMessage("[ Kategori Potion ]");
                List<Potion> sorted = ListUtil.sortByHargaKeseluruhan(daftarPotion);
                view.displayList(sorted, false);
            }
            if (!daftarWeapon.isEmpty()) {
                view.printMessage("[ Kategori Weapon ]");
                List<Weapon> sorted = ListUtil.sortByHargaKeseluruhan(daftarWeapon);
                view.displayList(sorted, false);
            }
            if (!daftarArmor.isEmpty()) {
                view.printMessage("[ Kategori Armor ]");
                List<Armor> sorted = ListUtil.sortByHargaKeseluruhan(daftarArmor);
                view.displayList(sorted, false);
            }
        } catch (EmptyListException e) {
            view.printError(e.getMessage());
        }
    }

    private void displayListSatuan() {
        try {
            listEmpty();
            view.printMessage("\n--- Daftar Terurut Harga Satuan Termurah ---");
            
            if (!daftarPotion.isEmpty()) {
                view.printMessage("[ Kategori Potion ]");
                List<Potion> sorted = ListUtil.sortByHargaSatuan(daftarPotion);
                view.displayList(sorted, true);
            }
            if (!daftarWeapon.isEmpty()) {
                view.printMessage("[ Kategori Weapon ]");
                List<Weapon> sorted = ListUtil.sortByHargaSatuan(daftarWeapon);
                view.displayList(sorted, true);
            }
            if (!daftarArmor.isEmpty()) {
                view.printMessage("[ Kategori Armor ]");
                List<Armor> sorted = ListUtil.sortByHargaSatuan(daftarArmor);
                view.displayList(sorted, true);
            }
        } catch (EmptyListException e) {
            view.printError(e.getMessage());
        }
    }

    private void listEmpty() throws EmptyListException {
        if (daftarPotion.isEmpty() && daftarWeapon.isEmpty() && daftarArmor.isEmpty()) {
            throw new EmptyListException("Semua daftar barang lelang kosong!");
        }
    }
}