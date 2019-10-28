package coffeeMachine;

import java.math.BigDecimal;

public class UserOrder {
    private final DrinkType drink;
    private final int sugar;
    private final BigDecimal money;

    public UserOrder(DrinkType drink, int sugar, BigDecimal money) {
        this.drink = drink;
        this.sugar = sugar;
        this.money = money;
    }

    public String getDrink() {
        return drink.getDrink();
    }

    public String getSugar() {
        if (sugar > 0) {
            return String.valueOf(sugar);
        }
        return "";
    }

    public String getStick() {
        if (sugar > 0) {
            return "0";
        }
        return "";
    }

    public BigDecimal priceCompare() {
        return BigDecimal.valueOf(0.40).subtract(money);
    }
}
