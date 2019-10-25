package coffeeMachine;

public class ProtocolDrinkMaker {
    public String format(UserOrder userOrder) {
        return userOrder.getDrink() + ":" + userOrder.getSugar() + ":" + userOrder.getStick();
    }

    public String format(String message) {
        return "M:" + message;
    }
}