package coffeeMachine;

import java.math.BigDecimal;

public class CoffeeMachine {

    private final DrinkMaker drinkMaker;
    private final ProtocolDrinkMaker protocolDrinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker, ProtocolDrinkMaker protocolDrinkMaker) {
        this.drinkMaker = drinkMaker;
        this.protocolDrinkMaker = protocolDrinkMaker;
    }

    public void order(UserOrder userOrder) {
        BigDecimal priceCompare = userOrder.priceCompare();
        if (moneyIsGreater(priceCompare)) {
            drinkMaker.send(protocolDrinkMaker.format(userOrder));
        } else {
            drinkMaker.send(protocolDrinkMaker.format(priceCompare, userOrder.getDrink()));
        }
    }

    private boolean moneyIsGreater(BigDecimal priceCompare) {
        return BigDecimal.valueOf(0.0).compareTo(priceCompare) >= 0;
    }

    public void displayMessage(String message) {
        drinkMaker.send(protocolDrinkMaker.format(message));
    }

    public String report() {
        return "";
    }
}
