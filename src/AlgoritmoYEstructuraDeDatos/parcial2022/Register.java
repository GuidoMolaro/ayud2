package AlgoritmoYEstructuraDeDatos.parcial2022;

import AlgoritmoYEstructuraDeDatos.Interfaces.DynamicQueue;

public class Register {
    private DynamicQueue<Order> expressOrders;
    private DynamicQueue<Order> normalOrders;
    private double revenue;

    public Register() {
        this.expressOrders = new DynamicQueue<>();
        this.normalOrders = new DynamicQueue<>();
        this.revenue = 0;
    }

    public int receiveOrder(Order order, int[] stock, int failedOrders){
        Product i = order.getItem();
        switch (i.getName()){
            case "Combo 1":
               if(processOrder(stock[0],order)){
                   stock[0]--;
               }else{
                   failedOrders++;
               }
                break;
            case "Combo 2":
                if(processOrder(stock[1],order)){
                    stock[1]--;
                }else{
                    failedOrders++;
                }
                break;
            case "Combo 3":
                if(processOrder(stock[2],order)){
                    stock[2]--;
                }else{
                    failedOrders++;
                }
                break;
        }
        return failedOrders;
    }

    private boolean processOrder(int stock, Order order){
        if(stock == 0){
            return false;
        }
        if(order.isExpress()){
            expressOrders.enqueue(order);
        }else {
            normalOrders.enqueue(order);
        }
        revenue += order.getPrice();
        return true;
    }
    //GETTERS & SETTERS
    public DynamicQueue<Order> getExpressOrders() {
        return expressOrders;
    }

    public DynamicQueue<Order> getNormalOrders() {
        return normalOrders;
    }

    public double getRevenue() {
        return revenue;
    }
}
