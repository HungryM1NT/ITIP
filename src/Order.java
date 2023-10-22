import java.util.LinkedList;
public class Order {
    private String orderDate;
    private LinkedList orderList;
    private String orderStatus;

    public Order() {
        orderDate = null;
        orderList = new LinkedList();
        orderStatus = null;
    }

    public Order(String date, LinkedList list, String status) {
        orderDate = date;
        orderList = list;
        orderStatus = status;
    }

    public String getOrderDate() {
        return orderDate;
    }
    public LinkedList getOrderList() {
        return orderList;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderDate(String date) {
        orderDate = date;
    }
    public void setOrderList(LinkedList list) {
        orderList = list;
    }
    public void setOrderStatus(String status) {
        orderStatus = status;
    }

    public void addInList(String product) {
        orderList.add(product);
    }
}
