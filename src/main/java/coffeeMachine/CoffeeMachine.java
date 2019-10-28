package coffeeMachine;

import java.math.BigDecimal;

public class CoffeeMachine {

    private static final String SEPARATION = ":";
    private static final String MESSAGE = "M:";
    private final DrinkMaker drinkMaker;
    private final ProtocolDrinkMaker protocolDrinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker, ProtocolDrinkMaker protocolDrinkMaker) {
        this.drinkMaker = drinkMaker;
        this.protocolDrinkMaker = protocolDrinkMaker;
    }

    public void order(UserOrder userOrder) {
        BigDecimal priceCompare = userOrder.priceCompare();
        if (priceCompare.compareTo(BigDecimal.valueOf(0.0)) <= 0) {
            drinkMaker.send(protocolDrinkMaker.format(userOrder));
        } else {
            this.displayMessage("It is missing " + priceCompare + " dollars to buy a tea");
        }
    }

    public void displayMessage(String message) {
        drinkMaker.send(protocolDrinkMaker.format(message));
    }
}
