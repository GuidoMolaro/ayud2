package AlgoritmoYEstructuraDeDatos.parcial2022;

import AlgoritmoYEstructuraDeDatos.Interfaces.DynamicQueue;
import AlgoritmoYEstructuraDeDatos.Lists.OrderedList;
import AlgoritmoYEstructuraDeDatos.utils.IsEmptyException;

public class Kitchen {
    int quantityOfEmployees;

    public Kitchen(int quantityOfEmployees) {
        this.quantityOfEmployees = quantityOfEmployees;
    }

    public void deliverOrder(DynamicQueue<Order> express,DynamicQueue<Order> normal,int i, OrderedList<Order> fOrders) throws IsEmptyException {
        Order order;
        if(express.isEmpty() && !normal.isEmpty()){
                order = normal.dequeue();
        }else{
            order = express.dequeue();
        }
        order.setDeliveredTime(i);
        fOrders.add(order);

    }
}
