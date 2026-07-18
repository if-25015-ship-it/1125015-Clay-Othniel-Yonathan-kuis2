package trade.view;
import trade.model.abstractclass.Item;
import java.util.List;

public class TradeView {

    public void showMenu() {
        System.out.println("\n=== Barang Lelang ===");
        System.out.println("1. Tambah barang");
        System.out.println("2. Tampilkan berdasarkan harga dari yang paling murah secara keseluruhan");
        System.out.println("3. Tampilkan berdasarkan harga dari yang satuannya paling murah ");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu [1-4]: ");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String error) {
        System.err.println("[ERROR] " + error);
    }

    public <T extends Item> void displayList(List<T> list, boolean showSatuan) {
        for (T barang : list) {
            if (showSatuan) {
                System.out.printf("%s, total unit %d, harga satuan @%.1f\n", 
                        barang.getNama(), barang.getJumlah(), barang.getHarga());
            } else {
                System.out.printf("%s, total unit %d, total harga %.1f\n", 
                        barang.getNama(), barang.getJumlah(), barang.getHargaJualKeseluruhan());
            }
        }
    }
}