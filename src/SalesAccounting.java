import java.util.*;
public class SalesAccounting {
    public static void productAdd(String product, int value) {
        if (SixthLab.productMap.containsKey(product)) {
            SixthLab.productMap.put(product, SixthLab.productMap.get(product) + value);
        }
        else {
            SixthLab.productMap.put(product, value);
        }
    }

    public static String productList() {
        return SixthLab.productMap.keySet().toString();
    }

    public static int totalSum() {
        int sum = 0;
        for (Object product: SixthLab.productMap.keySet().toArray()) {
            sum += SixthLab.productMap.get(product) * getPrice(product.toString());
        }
        return sum;
    }

    public static String mostPopularProduct() {
        List productList = new ArrayList<>(SixthLab.productMap.entrySet());
        Collections.sort(productList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return productList.get(0).toString().split("=")[0];
    }

    private static int getPrice(String product) {
        int price = 0;
        switch (product) {
            case "apple" -> price = 34;
            case "pear" -> price = 41;
            case "grape" -> price = 51;
            case "orange" -> price = 43;
        }
        return price;
    }
}

