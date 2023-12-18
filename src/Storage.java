import java.util.ArrayList;
import java.util.List;

public class Storage {
    List<Good> goodsList;

    public Storage() {
        this.goodsList = new ArrayList<>();
    }

    public synchronized void giveProduct(Good product) {
        goodsList.add(product);
    }

    public synchronized Good getProduct() {
        try {
            Good nowProduct = goodsList.getFirst();
            goodsList.removeFirst();
            return nowProduct;
        }
        catch (Exception e) {
            return new Good(-1);
        }
    }

    public boolean isEmpty() {
        return goodsList.isEmpty();
    }
}
