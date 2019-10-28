package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class ReportDrinkMachine {
    private List<UserOrder> orders = new ArrayList<UserOrder>();

    public List<UserOrder> Orders() {
        return orders;
    }

    public void add(UserOrder order) {
        orders.add(order);
    }

    public int OrdersOfType(DrinkType drinkType) {
        int count = 0;
        for (UserOrder userOrder : orders) {
            if (userOrder.getDrink().equals(drinkType)) {
                count++;
            }
        }
        return count;
    }
}
