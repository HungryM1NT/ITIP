import java.util.ArrayList;
import java.util.List;

public class Car {
    int amount;
    List<Good> goodsList;
    String place;
    int waitMembers;
    public Car() {
        this.amount = 0;
        this.goodsList = new ArrayList<>();
        this.place = "storage1";
        this.waitMembers = 0;
    }

    public synchronized void giveProduct(Good product) {
        goodsList.add(product);
        amount += product.weight;
    }

    public synchronized Good getProduct() {
        try {
            Good nowProduct = goodsList.getFirst();
            goodsList.removeFirst();
            amount -= nowProduct.weight;
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
