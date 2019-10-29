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

    public void order(Order order) {
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);
        BigDecimal priceCompare = userOrderEntity.priceCompare();
        if (moneyIsGreater(priceCompare)) {
            makeDrinkOrSendEmail(order, userOrderEntity);
        } else {
            drinkMaker.send(protocolDrinkMaker.formatMissingMoney(priceCompare, order.getDrinkType().getDrinkName()));
        }
    }

    private void makeDrinkOrSendEmail(Order order, UserOrderEntity userOrderEntity) {
        String drinkName = order.getDrinkType().getDrinkName();

        if (beverageQuantityChecker.isEmpty(drinkName)) {
            emailNotifier.notifyMissingDrink(drinkName);
            drinkMaker.send(protocolDrinkMaker.formatDrinkEmpty(drinkName));
        } else {
            reportDrinkMachine.add(order.getDrinkType());
            drinkMaker.send(protocolDrinkMaker.formatToDrinkMaker(userOrderEntity));
        }
    }

    private boolean moneyIsGreater(BigDecimal priceCompare) {
        return BigDecimal.valueOf(0.0).compareTo(priceCompare) >= 0;
    }

    public void report() {
        drinkMaker.printReport(reportDrinkMachine.reportMessage());
    }
}
