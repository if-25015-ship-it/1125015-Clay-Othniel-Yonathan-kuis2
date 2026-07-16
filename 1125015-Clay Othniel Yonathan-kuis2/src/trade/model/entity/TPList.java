import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TPList<T extends Item> {
    private List<T> listBarang = new ArrayList<>();

    public void tambahBarang(T barang) {
        listBarang.add(barang);
    }

    public List<T> getList() {
        return listBarang;
    }
    
}