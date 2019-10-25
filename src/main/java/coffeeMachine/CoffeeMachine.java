package coffeeMachine;

public class CoffeeMachine {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";

    public String order(UserOrder userOrder) {
        return userOrder.getDrink() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick();
    }

    public String displayMessage(String message) {
        return MESSAGE + message;
    }
}
