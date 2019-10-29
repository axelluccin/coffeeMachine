package coffeeMachine;

import java.math.BigDecimal;

public class ProtocolDrinkMaker {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";
    private static final String IT_IS_MISSING = "It is missing ";
    private static final String DOLLARS_TO_BUY_A = " dollars to buy a ";

    public String formatToDrinkMaker(UserOrder userOrder) {
        return userOrder.getDrinkProtocol() + userOrder.drinkHot() + SEPARATION + userOrder.getSugar() + SEPARATION + userOrder.getStick();
    }

    private String formatMessage(String message) {
        return MESSAGE + message;
    }

    public String formatMissingMoney(BigDecimal missingMoney, String drinkName) {
        return formatMessage(IT_IS_MISSING + missingMoney + DOLLARS_TO_BUY_A + drinkName);
    }

    public String formatDrinkEmpty(String drinkName) {
        return formatMessage(drinkName + "is empty on coffee machine. Please reloading the machine");
    }
}
