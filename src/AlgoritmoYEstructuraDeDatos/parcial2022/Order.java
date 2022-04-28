package AlgoritmoYEstructuraDeDatos.parcial2022;

public class Order implements Comparable<Order> {
    private int id;
    private int orderedTime;
    private int deliveredTime;
    private Product item;
    private double price;
    private boolean isExpress;

    public Order(int id, int orderedTime, Product item, boolean isExpress) {
        this.id = id;
        this.orderedTime = orderedTime;
        this.item = item;
        this.isExpress = isExpress;
        this.price= item.getPrice();
        if(isExpress) {
            this.price *= 1.1;
        }
    }

    public int getId() {
        return id;
    }

    public int getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(int orderedTime) {
        this.orderedTime = orderedTime;
    }

    public int getDeliveredTime() {
        return deliveredTime;
    }

    public void setDeliveredTime(int deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(o.deliveredTime-o.orderedTime, this.deliveredTime-this.orderedTime);
    }
}
