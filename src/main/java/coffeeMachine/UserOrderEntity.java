package coffeeMachine;

import java.math.BigDecimal;

public class UserOrderEntity {

    private final Order order;

    public UserOrderEntity(Order order) {
        this.order = order;
    }

    public String getDrinkProtocol() {
        return order.getDrinkType().getDrinkProtocol();
    }

    public String getSugar() {
        if (order.getSugar() > 0) {
            return String.valueOf(order.getSugar());
        }
        return "";
    }

    public String getStick() {
        if (order.getSugar() > 0) {
            return "0";
        }
        return "";
    }

    public BigDecimal priceCompare() {
        return order.getDrinkType().getCost().subtract(order.getMoney());
    }

    public String drinkHot() {
        if (order.isHot())
            return "h";
        return "";
    }
}
