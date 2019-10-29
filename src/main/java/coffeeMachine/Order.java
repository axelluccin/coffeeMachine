package coffeeMachine;

import java.math.BigDecimal;

public class Order {
    private final DrinkType drinkType;
    private final int sugar;
    private final BigDecimal money;
    private final boolean isHot;

    public Order(DrinkType drinkType, int sugar, BigDecimal money, boolean isHot) {
        this.drinkType = drinkType;
        this.sugar = sugar;
        this.money = money;
        this.isHot = isHot;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getSugar() {
        return sugar;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public boolean isHot() {
        return isHot;
    }
}
