package coffeeMachine;

public class CoffeeMachine {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";

    public String order(UserOrder userOrder) {
        if (!userOrder.getMessage().isEmpty()) {
            return MESSAGE + userOrder.getMessage();
        }
        return userOrder.getDrink() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick();
    }
}
