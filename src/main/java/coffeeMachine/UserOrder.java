package coffeeMachine;

public class UserOrder {
    private final DrinkType drink;
    private final int sugar;

    public UserOrder(DrinkType drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
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
}