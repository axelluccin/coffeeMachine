package coffeeMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReportDrinkMachine {
    private static final String SPACE = " ";
    private static final String VIRGULE = ", ";
    private static final String MONEY_EARNED = "money earned: ";
    private static final String DOLLARS = " dollars";

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
        return formatReportDrink(DrinkType.TEA)
                .append(formatReportDrink(DrinkType.CHOCOLATE))
                .append(formatReportDrink(DrinkType.COFFEE))
                .append(formatReportDrink(DrinkType.ORANGE))
                .append(MONEY_EARNED)
                .append(moneyOrders)
                .append(DOLLARS)
                .toString();
    }

    private StringBuilder formatReportDrink(DrinkType drinkType) {
        return new StringBuilder()
                .append(OrdersOfType(drinkType))
                .append(SPACE)
                .append(drinkType.getDrinkName())
                .append(VIRGULE);
    }
}
