package coffeeMachine;

public class ProtocolDrinkMaker {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";

    public String format(UserOrder userOrder) {
        return userOrder.getDrink() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick();
    }

    public String format(String message) {
        return MESSAGE + message;
    }
}
