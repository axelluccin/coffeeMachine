package coffeeMachine;

public class CoffeeMachine {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";
    private final DrinkMaker drinkMaker;
    private final ProtocolDrinkMaker protocolDrinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker, ProtocolDrinkMaker protocolDrinkMaker) {
        this.drinkMaker = drinkMaker;
        this.protocolDrinkMaker = protocolDrinkMaker;
    }

    public void order(UserOrder userOrder) {
        drinkMaker.send(userOrder.getDrink() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick());
    }

    public void displayMessage(String message) {
        drinkMaker.send(MESSAGE + message);
    }
}
