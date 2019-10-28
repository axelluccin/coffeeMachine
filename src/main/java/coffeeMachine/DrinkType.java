package coffeeMachine;

import java.math.BigDecimal;

public enum DrinkType {
    TEA("T", BigDecimal.valueOf(0.40), "tea"),
    CHOCOLATE("H", BigDecimal.valueOf(0.50), "chocolate"),
    COFFEE("C", BigDecimal.valueOf(0.60), "coffee");

    private final String drinkProtocol;
    private final BigDecimal cost;
    private final String drink;

    public String getDrinkProtocol() {
        return drinkProtocol;
    }

    public BigDecimal getCost() {
        return cost;
    }

    DrinkType(String drinkProtocol, BigDecimal cost, String drink) {
        this.drinkProtocol = drinkProtocol;
        this.cost = cost;
        this.drink = drink;
    }

    public String getDrink() {
        return drink;
    }
}
