package coffeeMachine;

public enum DrinkType {
    TEA("T"), CHOCOLATE("H"), COFFEE("C");

    private final String drink;

    public String getDrink() {
        return drink;
    }

    DrinkType(String drink) {
        this.drink = drink;
    }
}
