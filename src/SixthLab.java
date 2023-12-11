import java.util.*;

public class SixthLab {
    public static Map<String, Integer> productMap = new HashMap<>();
    public static void main(String[] args) {
        TopWords.topWords("topWords.txt");
        System.out.println();


        Stack<String> myStack = new Stack<>(4);
        myStack.push("Первое значение");
        myStack.push("Второе значение");
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        myStack.push("Третье значение");
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println();

        SalesAccounting.productAdd("apple", 4);
        SalesAccounting.productAdd("apple", 2);
        SalesAccounting.productAdd("grape", 12);
        SalesAccounting.productAdd("pear", 4);
        SalesAccounting.productAdd("orange", 6);
        System.out.println(SalesAccounting.productList());
        System.out.println(SalesAccounting.totalSum());
        System.out.println(SalesAccounting.mostPopularProduct());

    }
}
