package coffeeMachine;

public class UserOrder {
    private final DrinkType drink;
    private final int sugar;
    private final String message;

    public UserOrder(DrinkType drink, int sugar, String message) {
        this.drink = drink;
        this.sugar = sugar;
        this.message = message;
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


    public String getMessage() {
        return message;
    }
}
