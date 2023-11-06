import java.util.Arrays;
import java.util.LinkedList;

public class ThirdLab {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable<>();

        System.out.println(myHashTable.isEmpty());
        myHashTable.put("key", "value");
        myHashTable.put("key", "value2");
        System.out.println(myHashTable.size());
        myHashTable.put(1, Arrays.asList(1, 2, 3));
        myHashTable.put('a', 123);
        System.out.println(myHashTable.size());
        System.out.println(myHashTable.isEmpty());
        System.out.println();

        System.out.println(myHashTable.get("key"));
        System.out.println(myHashTable.get(1));
        System.out.println(myHashTable.get('a'));
        System.out.println();

        myHashTable.remove(1);
        myHashTable.remove(9999);
        System.out.println(myHashTable.size());
        System.out.println(myHashTable.get(1));
        System.out.println();

        HashTable<Integer, Order> secondHashTable = new HashTable<>();
        LinkedList products1 = new LinkedList<>(Arrays.asList("product1", "product2"));
        LinkedList products2 = new LinkedList<>(Arrays.asList("anotherProduct1", "anotherProduct2"));
        Order firstOrder = new Order("12 мая 2006", products1, "status1");
        Order secondOrder = new Order("18 июня 2006", products2, "status2");
        secondHashTable.put(1, firstOrder);
        secondHashTable.put(2, secondOrder);
        System.out.println(secondHashTable.get(1).getOrderList());
        secondHashTable.remove(1);

        System.out.println(secondHashTable.get(2).getOrderStatus());
        secondHashTable.get(2).setOrderStatus("newStatus2");
        System.out.println(secondHashTable.get(2).getOrderStatus());
    }
}
