package coffeeMachine;

public class UserOrder {
    private final DrinkType drink;
    private final int sugar;

    public UserOrder(DrinkType drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
    }

    public String getDrink() {
        return "T";
    }

    public String getSugar() {
        return String.valueOf(sugar);
    }
}
