package trade.view;

import java.util.Scanner;

public class TradeView {
    private final Scanner scanner;

    public TradeView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\n=== Barang Lelang ===");
        System.out.println("1. Tambah barang");
        System.out.println("2. Tampilkan berdasarkan harga dari yang paling murah secara keseluruhan");
        System.out.println("3. Tampilkan berdasarkan harga dari yang satuannya paling murah ");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu [1-4]: ");
    }

    public int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Harus angka");
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}