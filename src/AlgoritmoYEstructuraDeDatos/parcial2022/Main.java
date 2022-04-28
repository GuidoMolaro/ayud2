package AlgoritmoYEstructuraDeDatos.parcial2022;

import AlgoritmoYEstructuraDeDatos.Lists.OrderedList;
import AlgoritmoYEstructuraDeDatos.utils.IsEmptyException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IsEmptyException {
        int totalSimTime = 780; //Runtime between 10 and 23h
        int twentyTwo = 720; //Stops accepting orders at 22h
        int combo1Q = new Random().nextInt(200,250);
        int combo2Q = new Random().nextInt(200,250);
        int combo3Q = new Random().nextInt(200,250);
        int express = 0;
        int normal = 0;
        int[] stock = new int[3];
        stock[0] = combo1Q;
        stock[1] = combo2Q;
        stock[2] = combo3Q;
        int failedOrders = 0;
        OrderedList<Order> fOrders = new OrderedList<>();
        Kitchen kitchen = new Kitchen(3);
        Register register = new Register();
        int time = 0;
        while(time<totalSimTime){
            if(time<twentyTwo){
               failedOrders = register.receiveOrder(createOrder(time), stock,failedOrders);
               failedOrders = register.receiveOrder(createOrder(time), stock,failedOrders);
               failedOrders = register.receiveOrder(createOrder(time), stock,failedOrders);
               failedOrders = register.receiveOrder(createOrder(time), stock,failedOrders);
            }
            time += 5;
            for (int i = 0; i < kitchen.quantityOfEmployees; i++) {
                kitchen.deliverOrder(register.getExpressOrders(),register.getNormalOrders(),time,fOrders);
            }
        }
        Reporter reporter = new Reporter();
        reporter.quantitiesSold(stock,combo1Q,combo2Q,combo3Q);
        reporter.SlowestOrder(fOrders);
        reporter.failedOrders(failedOrders);
        reporter.revenue(register);
    }

    public static Order createOrder(int time){
        int i = new Random().nextInt(3);
        Order order;
        if(Math.random()<=0.1) {
            switch (i) {
                case 0 -> order = new Order(new Random().nextInt(0,1000), time,  new Product("Combo 1", 120), true);
                case 1 -> order = new Order(new Random().nextInt(0,1000), time, new Product("Combo 2", 140), true);
                default -> order = new Order(new Random().nextInt(0,1000), time, new Product("Combo 3", 180), true);
            }
        } else{
            switch (i) {
                case 0 -> order = new Order(new Random().nextInt(1001,3000), time,  new Product("Combo 1", 120), false);
                case 1 -> order = new Order(new Random().nextInt(1001,3000), time, new Product("Combo 2", 140), false);
                default -> order = new Order(new Random().nextInt(1001,3000), time, new Product("Combo 3", 180), false);
            }
        }
        return order;
    }
}
