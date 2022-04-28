package AlgoritmoYEstructuraDeDatos.parcial2022;

import AlgoritmoYEstructuraDeDatos.Lists.OrderedList;

public class Reporter {

    public Reporter(){}

    public void quantitiesSold(int[] stock, int i, int n, int m){
        int[] values = new int[3];
        values[0] = i-stock[0];
        values[1] = n-stock[1];
        values[2] = m-stock[2];
        System.out.println("Sold: " + values[0]+ " Combos 1.");
        System.out.println("Sold: " + values[1]+ " Combos 2.");
        System.out.println("Sold: " + values[2]+ " Combos 3.");
    }

    public void SlowestOrder(OrderedList<Order> fOrder){
        fOrder.goTo(0);
        Order order = fOrder.getActual();
        fOrder.goTo(fOrder.size()-1);
        Order order1 = fOrder.getActual();
        System.out.println("Slowest order: " + order.getId() + ": " + (order.getDeliveredTime()- order.getOrderedTime()) + " minutes.");
        System.out.println("Fastest order: " + order1.getId() + ": " + (order1.getDeliveredTime()- order1.getOrderedTime()) + " minutes.");
    }

    public void failedOrders(int failedOrders){
        System.out.println("There were " + failedOrders + " failed orders because of lack of stock.");
    }

    public void revenue(Register register){
        System.out.println("Today, the restaurant generated $" + register.getRevenue() +" in revenue.");
    }
}
