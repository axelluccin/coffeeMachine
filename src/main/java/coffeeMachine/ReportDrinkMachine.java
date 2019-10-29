package coffeeMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReportDrinkMachine {
    private static final String SPACE = " ";
    private static final String VIRGULE = ", ";
    private static final String MONEY_EARNED = ". Money earned: ";
    private static final String DOLLARS = " dollars";
    private static final String AND = " and ";

    private List<DrinkType> orders = new ArrayList<>();
    private BigDecimal moneyOrders = BigDecimal.ZERO;

    public List<DrinkType> Orders() {
        return orders;
    }

    public void add(DrinkType order) {
        orders.add(order);
        moneyOrders = moneyOrders.add(order.getCost());
    }

    public int OrdersOfType(DrinkType drinkType) {
        return (int) orders
                .stream()
                .filter(userOrder -> userOrder.equals(drinkType))
                .count();
    }

    public String reportMessage() {
        return new StringBuilder()
                .append(OrdersOfType(DrinkType.TEA))
                .append(SPACE)
                .append(DrinkType.TEA.getDrink())
                .append(VIRGULE)
                .append(OrdersOfType(DrinkType.CHOCOLATE))
                .append(SPACE)
                .append(DrinkType.CHOCOLATE.getDrink())
                .append(VIRGULE)
                .append(OrdersOfType(DrinkType.COFFEE))
                .append(SPACE)
                .append(DrinkType.COFFEE.getDrink())
                .append(AND)
                .append(OrdersOfType(DrinkType.ORANGE))
                .append(SPACE)
                .append(DrinkType.ORANGE.getDrink())
                .append(MONEY_EARNED)
                .append(moneyOrders).append(DOLLARS)
                .toString();
    }
}
