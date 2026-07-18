package trade.model.entity;

import java.util.List;
import trade.model.abstractclass.Item;

public class TPList<T extends Item> {
    private List<T> listBarang = new ArrayList<>();

    public void tambahBarang(T barang) {
        listBarang.add(barang);
    }

    public List<T> getList() {
        return listBarang;
    }
    
}