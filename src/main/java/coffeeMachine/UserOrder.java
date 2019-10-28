package coffeeMachine;

import java.math.BigDecimal;

public class UserOrder {
    private final DrinkType drink;
    private final int sugar;
    private final BigDecimal money;
    private final boolean isHot;

    public UserOrder(DrinkType drink, int sugar, BigDecimal money, boolean isHot) {
        this.drink = drink;
        this.sugar = sugar;
        this.money = money;
        this.isHot = isHot;
    }

    public String getDrinkProtocol() {
        return drink.getDrinkProtocol();
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
        return drink.getCost().subtract(money);
    }

    public DrinkType getDrink() {
        return drink;
    }

    public String drinkHot() {
        if (isHot)
            return "h";
        return "";
    }
}
