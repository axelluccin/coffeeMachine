package coffeeMachine;

public class CoffeeMachine {
    public String order(UserOrder userOrder) {
        return userOrder.getDrink() + ":" + userOrder.getSugar() + ":" + userOrder.getStick();
    }
}
