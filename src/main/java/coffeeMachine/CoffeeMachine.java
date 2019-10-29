package coffeeMachine;

import java.math.BigDecimal;

public class CoffeeMachine {

    private final DrinkMaker drinkMaker;
    private final ProtocolDrinkMaker protocolDrinkMaker;
    private final ReportDrinkMachine reportDrinkMachine;
    private final EmailNotifier emailNotifier;
    private final BeverageQuantityChecker beverageQuantityChecker;

    public CoffeeMachine(DrinkMaker drinkMaker,
                         ProtocolDrinkMaker protocolDrinkMaker,
                         ReportDrinkMachine reportDrinkMachine,
                         EmailNotifier emailNotifier,
                         BeverageQuantityChecker beverageQuantityChecker) {
        this.drinkMaker = drinkMaker;
        this.protocolDrinkMaker = protocolDrinkMaker;
        this.reportDrinkMachine = reportDrinkMachine;
        this.emailNotifier = emailNotifier;
        this.beverageQuantityChecker = beverageQuantityChecker;
    }

    public void order(UserOrder userOrder) {
        BigDecimal priceCompare = userOrder.priceCompare();
        if (moneyIsGreater(priceCompare)) {
            makeDrinkOrSendEmail(userOrder);
        } else {
            drinkMaker.send(protocolDrinkMaker.formatMissingMoney(priceCompare, userOrder.getDrink().getDrinkName()));
        }
    }

    private void makeDrinkOrSendEmail(UserOrder userOrder) {
        String drinkName = userOrder.getDrink().getDrinkName();

        if (beverageQuantityChecker.isEmpty(drinkName)) {
            reportDrinkMachine.add(userOrder.getDrink());
            drinkMaker.send(protocolDrinkMaker.formatToDrinkMaker(userOrder));
        } else {
            emailNotifier.notifyMissingDrink(drinkName);
            drinkMaker.send(protocolDrinkMaker.formatDrinkEmpty(drinkName));
        }
    }

    private boolean moneyIsGreater(BigDecimal priceCompare) {
        return BigDecimal.valueOf(0.0).compareTo(priceCompare) >= 0;
    }

    public void report() {
        drinkMaker.printReport(reportDrinkMachine.reportMessage());
    }
}
