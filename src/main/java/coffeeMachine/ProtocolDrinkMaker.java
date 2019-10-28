package coffeeMachine;

import java.math.BigDecimal;

public class ProtocolDrinkMaker {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";
    private static final String IT_IS_MISSING = "M:It is missing ";
    private static final String DOLLARS_TO_BUY_A = " dollars to buy a ";

    public String format(UserOrder userOrder) {
        return userOrder.getDrinkProtocol() + userOrder.drinkHot() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick();
    }

    public String format(String message) {
        return MESSAGE + message;
    }

    public String format(BigDecimal missingMoney, DrinkType drinkType) {
        return IT_IS_MISSING + missingMoney + DOLLARS_TO_BUY_A + drinkType.getDrink();
    }
}
