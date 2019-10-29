package coffeeMachine;

import java.math.BigDecimal;

public class ProtocolDrinkMaker {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";
    private static final String MISSING = "It is missing ";
    private static final String DOLLARS = " dollars to buy a ";
    private static final String EMPTY_DRINK_END = " in coffee machine. A Email was sent to reload the coffee machine";
    private static final String EMPTY_DRINK_START = "There is no ";

    public String formatToDrinkMaker(UserOrderEntity userOrderEntity) {
        return userOrderEntity.getDrinkProtocol() + userOrderEntity.drinkHot() + SEPARATION + userOrderEntity.getSugar() + SEPARATION + userOrderEntity.getStick();
    }

    public String formatMissingMoney(BigDecimal missingMoney, String drinkName) {
        return formatMessage(MISSING + missingMoney + DOLLARS + drinkName);
    }

    public String formatDrinkEmpty(String drinkName) {
        return formatMessage(EMPTY_DRINK_START + drinkName + EMPTY_DRINK_END);
    }

    private String formatMessage(String message) {
        return MESSAGE + message;
    }
}
