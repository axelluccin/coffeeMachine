package coffeeMachine;

import java.math.BigDecimal;

public class ProtocolDrinkMaker {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";

    public String format(UserOrder userOrder) {
        return userOrder.getDrink() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick();
    }

    public String format(String message) {
        return MESSAGE + message;
    }

    public String format(BigDecimal missingMoney, DrinkType drinkType) {
        return MESSAGE + "It is missing " + missingMoney + " dollars to buy a " + drinkType.getDrink();
    }
}
