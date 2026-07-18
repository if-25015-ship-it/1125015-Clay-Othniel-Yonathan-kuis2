package trade.util;

import trade.model.abstractclass.Item;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListUtil {

    public static <T extends Item> List<T> sortByHargaKeseluruhan(List<T> list) {
        List<T> sortedList = new ArrayList<>(list);
        sortedList.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Double.compare(o1.getHargaJualKeseluruhan(), o2.getHargaJualKeseluruhan());
            }
        });
        return sortedList;
    }

    public static <T extends Item> List<T> sortByHargaSatuan(List<T> list) {
        List<T> sortedList = new ArrayList<>(list);
        sortedList.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Double.compare(o1.getHarga(), o2.getHarga());
            }
        });
        return sortedList;
    }
}