package coffeeMachine;

import java.math.BigDecimal;

public class CoffeeMachine {

    private final DrinkMaker drinkMaker;
    private final ProtocolDrinkMaker protocolDrinkMaker;
    private final ReportDrinkMachine reportDrinkMachine;

    public CoffeeMachine(DrinkMaker drinkMaker, ProtocolDrinkMaker protocolDrinkMaker, ReportDrinkMachine reportDrinkMachine) {
        this.drinkMaker = drinkMaker;
        this.protocolDrinkMaker = protocolDrinkMaker;
        this.reportDrinkMachine = reportDrinkMachine;
    }

    public void order(UserOrder userOrder) {
        BigDecimal priceCompare = userOrder.priceCompare();
        if (moneyIsGreater(priceCompare)) {
            reportDrinkMachine.add(userOrder.getDrink());
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

    public void report() {
        drinkMaker.printReport(reportDrinkMachine.reportMessage());
    }
}
