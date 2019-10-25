package coffeeMachine;

public class CoffeeMachine {

    private static final String MESSAGE_CONTENT = "M:message-content";
    private static final String SEPARATION = ":";

    public String order(UserOrder userOrder) {
        if (userOrder.isMessage()) {
            return MESSAGE_CONTENT;
        }
        return userOrder.getDrink() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick();
    }
}
