package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class ReportDrinkMachine {
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> Orders() {
        return orders;
    }

    public void add(Order order) {
        orders.add(order);
    }
}
