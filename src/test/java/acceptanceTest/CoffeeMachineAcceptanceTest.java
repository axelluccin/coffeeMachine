package acceptanceTest;

import coffeeMachine.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class CoffeeMachineAcceptanceTest {

    private DrinkMaker drinkMaker;
    private CoffeeMachine coffeeMachine;
    private BeverageQuantityChecker beverageQuantityChecker;
    private EmailNotifier emailNotifier;

    @Before
    public void setUp() throws Exception {
        drinkMaker = mock(DrinkMaker.class);
        emailNotifier = mock(EmailNotifier.class);
        beverageQuantityChecker = mock(BeverageQuantityChecker.class);

        ProtocolDrinkMaker protocolDrinkMaker = new ProtocolDrinkMaker();
        ReportDrinkMachine reportDrinkMachine = new ReportDrinkMachine();
        coffeeMachine = new CoffeeMachine(drinkMaker, protocolDrinkMaker, reportDrinkMachine, emailNotifier, beverageQuantityChecker);
    }

    @Test
    public void when_customer_order_a_tea_with_sugar_then_coffee_machine_return_the_good_protocol() {
        Order userOrderEntity = new Order(DrinkType.TEA, 1, BigDecimal.valueOf(0.40), false);
        when(beverageQuantityChecker.isEmpty(anyString())).thenReturn(false);

        coffeeMachine.order(userOrderEntity);

        verify(drinkMaker).send("T:1:0");
    }

    @Test
    public void when_customer_order_a_chocolate_with_no_sugar_then_the_coffee_machine_send_good_protocol() {
        Order userOrderEntity = new Order(DrinkType.CHOCOLATE, 0, BigDecimal.valueOf(0.50), false);
        when(beverageQuantityChecker.isEmpty(anyString())).thenReturn(false);

        coffeeMachine.order(userOrderEntity);

        verify(drinkMaker).send("H::");
    }

    @Test
    public void when_customer_order_a_coffee_with_2_sugar_then_the_coffee_machine_send_good_protocol() {
        Order order = new Order(DrinkType.COFFEE, 2, BigDecimal.valueOf(0.60), false);
        when(beverageQuantityChecker.isEmpty(anyString())).thenReturn(false);

        coffeeMachine.order(order);

        verify(drinkMaker).send("C:2:0");
    }

    @Test
    public void when_user_order_a_tea_and_give_30_cents_then_the_coffee_machine_should_send_the_message_protocol_to_the_drink_maker() {
        Order order = new Order(DrinkType.TEA, 0, BigDecimal.valueOf(0.3), false);

        coffeeMachine.order(order);

        verify(drinkMaker).send("M:It is missing 0.1 dollars to buy a tea");
    }

    @Test
    public void when_user_order_a_orange_juice_and_give_60_cents_then_coffee_machine_should_send_the_message_protocol_to_the_drink_maker() {
        Order order = new Order(DrinkType.ORANGE, 0, BigDecimal.valueOf(0.60), false);
        when(beverageQuantityChecker.isEmpty(anyString())).thenReturn(false);

        coffeeMachine.order(order);

        verify(drinkMaker).send("O::");
    }

    @Test
    public void when_user_order_a_coffee_extra_hot_then_coffee_machine_should_send_the_message_protocol_to_the_drink_maker() {
        Order order = new Order(DrinkType.COFFEE, 0, BigDecimal.valueOf(0.60), true);
        when(beverageQuantityChecker.isEmpty(anyString())).thenReturn(false);

        coffeeMachine.order(order);

        verify(drinkMaker).send("Ch::");
    }

    @Test
    public void when_users_make_some_orders_then_coffee_machine_should_return_the_report_of_orders() {
        Order orderTea = new Order(DrinkType.TEA, 0, DrinkType.TEA.getCost(), false);
        Order orderChocolate = new Order(DrinkType.CHOCOLATE, 0, DrinkType.CHOCOLATE.getCost(), false);
        Order orderCoffee = new Order(DrinkType.COFFEE, 0, DrinkType.COFFEE.getCost(), false);
        Order orderOrange = new Order(DrinkType.ORANGE, 0, DrinkType.ORANGE.getCost(), false);

        when(beverageQuantityChecker.isEmpty(anyString())).thenReturn(false);
        allCommand(orderTea, orderChocolate, orderCoffee, orderOrange);

        coffeeMachine.report();

        verify(drinkMaker).printReport("2 tea, 3 chocolate, 1 coffee, 7 orange, money earned: 7.1 dollars");
    }

    @Test
    public void when_user_order_a_drink_and_drink_machine_got_no_drink_then_coffee_machine_should_send_email_and_notify_user_shortage() {
        Order order = new Order(DrinkType.TEA, 0, DrinkType.TEA.getCost(), false);
        when(beverageQuantityChecker.isEmpty(anyString())).thenReturn(true);

        coffeeMachine.order(order);

        verify(emailNotifier).notifyMissingDrink("tea");
        verify(drinkMaker).send("M:There is no tea in coffee machine. A Email was sent to reload the coffee machine");
    }

    private void allCommand(Order orderTea, Order orderChocolate, Order orderCoffee, Order orderOrange) {
        // TEA
        coffeeMachine.order(orderTea);
        coffeeMachine.order(orderTea);

        // CHOCOLATE
        coffeeMachine.order(orderChocolate);
        coffeeMachine.order(orderChocolate);
        coffeeMachine.order(orderChocolate);

        // COFFEE
        coffeeMachine.order(orderCoffee);

        // ORANGE
        coffeeMachine.order(orderOrange);
        coffeeMachine.order(orderOrange);
        coffeeMachine.order(orderOrange);
        coffeeMachine.order(orderOrange);
        coffeeMachine.order(orderOrange);
        coffeeMachine.order(orderOrange);
        coffeeMachine.order(orderOrange);
    }
}
