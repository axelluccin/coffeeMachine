package acceptanceTest;

import coffeeMachine.*;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineAcceptanceTest {

    private DrinkMaker drinkMaker;
    private ProtocolDrinkMaker protocolDrinkMaker;
    private CoffeeMachine coffeeMachine;
    private ReportDrinkMachine reportDrinkMachine;

    @Before
    public void setUp() throws Exception {
        drinkMaker = mock(DrinkMaker.class);
        protocolDrinkMaker = new ProtocolDrinkMaker();
        reportDrinkMachine = new ReportDrinkMachine();
        coffeeMachine = new CoffeeMachine(drinkMaker, protocolDrinkMaker, reportDrinkMachine);
    }

    @Test
    public void when_customer_order_a_tea_with_sugar_then_coffee_machine_return_the_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1, BigDecimal.valueOf(0.40), false);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("T:1:0");
    }

    @Test
    public void when_customer_order_a_chocolate_with_no_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.CHOCOLATE, 0, BigDecimal.valueOf(0.50), false);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("H::");
    }

    @Test
    public void when_customer_order_a_coffee_with_2_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.COFFEE, 2, BigDecimal.valueOf(0.60), false);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("C:2:0");
    }

    @Test
    public void display_a_message_then_coffee_machine_send_good_protocol() {
        coffeeMachine.displayMessage("un message");

        verify(drinkMaker).send("M:un message");
    }

    @Test
    public void when_user_order_a_tea_and_give_30_cents_then_the_coffee_machine_should_send_the_message_protocol_to_the_drink_maker() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 0, BigDecimal.valueOf(0.3), false);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("M:It is missing 0.1 dollars to buy a tea");
    }

    @Test
    public void when_user_order_a_orange_juice_and_give_60_cents_then_coffee_machine_should_send_the_message_protocol_to_the_drink_maker() {
        UserOrder userOrder = new UserOrder(DrinkType.ORANGE, 0, BigDecimal.valueOf(0.60), false);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("O::");
    }

    @Test
    public void when_user_order_a_coffee_extra_hot_then_coffee_machine_should_send_the_message_protocol_to_the_drink_maker() {
        UserOrder userOrder = new UserOrder(DrinkType.COFFEE, 0, BigDecimal.valueOf(0.60), true);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("Ch::");
    }


    @Test
    public void when_users_make_some_orders_then_coffee_machine_should_return_the_report_of_orders() {
        UserOrder userOrderTea = new UserOrder(DrinkType.TEA, 0, DrinkType.TEA.getCost(), false);
        UserOrder userOrderChocolate = new UserOrder(DrinkType.CHOCOLATE, 0, DrinkType.CHOCOLATE.getCost(), false);
        UserOrder userOrderCoffee = new UserOrder(DrinkType.COFFEE, 0, DrinkType.COFFEE.getCost(), false);
        UserOrder userOrderOrange = new UserOrder(DrinkType.ORANGE, 0, DrinkType.ORANGE.getCost(), false);

        allCommand(userOrderTea, userOrderChocolate, userOrderCoffee, userOrderOrange);

        String resultReport = coffeeMachine.report();
        Assertions.assertThat(resultReport).isEqualTo("2 tea, 3 chocolate, 1 coffee and 7 orange. Money earned: 7.1 dollars");
    }

    private void allCommand(UserOrder userOrderTea, UserOrder userOrderChocolate, UserOrder userOrderCoffee, UserOrder userOrderOrange) {
        coffeeMachine.order(userOrderTea);
        coffeeMachine.order(userOrderTea);

        coffeeMachine.order(userOrderChocolate);
        coffeeMachine.order(userOrderChocolate);
        coffeeMachine.order(userOrderChocolate);

        coffeeMachine.order(userOrderCoffee);

        coffeeMachine.order(userOrderOrange);
        coffeeMachine.order(userOrderOrange);
        coffeeMachine.order(userOrderOrange);
        coffeeMachine.order(userOrderOrange);
        coffeeMachine.order(userOrderOrange);
        coffeeMachine.order(userOrderOrange);
        coffeeMachine.order(userOrderOrange);
    }
}
