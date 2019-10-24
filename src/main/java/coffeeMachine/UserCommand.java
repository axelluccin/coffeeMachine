package coffeeMachine;

public class UserCommand {
    private final DrinkType drink;

    public UserCommand(DrinkType drink, int sugar) {
        this.drink = drink;
    }

    public String getDrink() {
        return "T";
    }

    public String getSugar() {
        return "0";
    }
}
