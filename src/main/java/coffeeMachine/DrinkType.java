package coffeeMachine;

import java.math.BigDecimal;

public enum DrinkType {
    TEA("T", BigDecimal.valueOf(0.40)),
    CHOCOLATE("H", BigDecimal.valueOf(0.60)),
    COFFEE("C", BigDecimal.valueOf(0.0));

    private final String drink;
    private final BigDecimal cost;

    public String getDrink() {
        return drink;
    }

    public BigDecimal getCost() {
        return cost;
    }

    DrinkType(String drink, BigDecimal cost) {
        this.drink = drink;
        this.cost = cost;
    }
}
