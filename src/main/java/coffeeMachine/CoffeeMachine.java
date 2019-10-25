package coffeeMachine;

public class CoffeeMachine {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void order(UserOrder userOrder) {
        drinkMaker.send(userOrder.getDrink() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick());
    }

    public void displayMessage(String message) {
        drinkMaker.send(MESSAGE + message);
    }
}
