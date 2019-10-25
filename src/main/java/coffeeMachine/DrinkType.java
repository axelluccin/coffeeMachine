package coffeeMachine;

public enum DrinkType {
    TEA("T"), CHOCOLATE("H");

    public String getDrink() {
        return drink;
    }

    private final String drink;

    DrinkType(String drink) {
        this.drink = drink;
    }
}
