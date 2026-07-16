// File: src/trade/controller/DeviceController.java
package trade.controller;

import trade.model.entity.TPList;
import trade.model.entity.Armor;
import trade.model.entity.Potion;
import trade.model.entity.Weapon;
import trade.view.TradeView;
import trade.model.exception.InvalidNumberException;
import trade.model.exception.EmptyListException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TradeController {
    // Penggunaan generic: menampung objek turunan dari Device
    TPList<Potion> potionList = new TPList<>();
    TPList<Weapon> weaponList = new TPList<>();
    TPList<Armor> armorList = new TPList<>();

    private final TradeView view;

    public TradeController(TradeView view) {
        this.view = view;
    }

    public void start() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.getMenuChoice();

            switch (choice) {
                case 1:
                    addBaranglelang();
                    break;
                case 2:
                    printSortedByTotal();
                    break;
                case 3:
                    printSortedByUnit();
                    break;
                case 0:
                    view.showMessage("Keluar dari program. Terima kasih!");
                    running = false;
                    break;
                default:
                    view.showMessage("Pilihan menu tidak valid!");
            }
        }
    }

    private void addBaranglelang() {
        view.showMessage("\n--- TAMBAH BARANG ---");
        view.showMessage("Pilih Jenis Barang:");
        view.showMessage("1. Potion");
        view.showMessage("2. Weapon");
        view.showMessage("3. Armor");
        view.showMessage("0. Keluar");
        int type = view.getIntInput("Pilih tipe: ");

        switch (type) {
            case 1:
                addPotion();
                break;
            case 2:
                addWeapon();
                break;
            case 3:
                addArmor();
                break;
            case 0:
                view.showMessage("Kembali ke menu utama.");
                break;
            default:
                view.showMessage("Pilihan tidak valid!");
        }
    }

    

    public static <E extends Item> void printSortedByTotal(List<E> items) throws EmptyListException {
        if (items.isEmpty()) {
            throw new EmptyListException("Daftar barang lelang di kategori ini masih kosong.");
        }

        List<E> temp = new ArrayList<>(items);

        Collections.sort(temp, new Comparator<E>() {
            @Override
            public int compare(E a, E b) {
                return Double.compare(a.getTotalHarga(), b.getTotalHarga());
            }
        });

        System.out.println("=== Urutan Harga Total Keseluruhan Termurah ===");
        for (E item : temp) {
            System.out.println(item.toString());
        }
    }

    //Generic method
    public static <E extends Item> void printSortedByUnit(List<E> items) throws EmptyListException {
        if (items.isEmpty()) {
            throw new EmptyListException("Daftar barang lelang kategori ini masih kosong.");
        }

        List<E> temp = new ArrayList<>(items);

        Collections.sort(temp, new Comparator<E>() {
            @Override
            public int compare(E a, E b) {
                return Double.compare(a.getHargaSatuan(), b.getHargaSatuan());
            }
        });

        System.out.println("=== Urutan Hrga Satuan Termurah ===");
        for (E item : temp) {
            System.out.println(item.toString() + " (harga satuan each :" + item.getHargaSatuan() + ")");
        }
    }
}