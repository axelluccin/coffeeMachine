package acceptanceTest;

import coffeeMachine.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineAcceptanceTest {

    private DrinkMaker drinkMaker;
    private ProtocolDrinkMaker protocolDrinkMaker;
    private CoffeeMachine coffeeMachine;

    @Before
    public void setUp() throws Exception {
        drinkMaker = mock(DrinkMaker.class);
        protocolDrinkMaker = new ProtocolDrinkMaker();
        coffeeMachine = new CoffeeMachine(drinkMaker, protocolDrinkMaker);
    }

    @Test
    public void when_customer_order_a_tea_with_sugar_then_coffee_machine_return_the_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1, BigDecimal.ZERO);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("T:1:0");
    }

    @Test
    public void when_customer_order_a_chocolate_with_no_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.CHOCOLATE, 0, BigDecimal.ZERO);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("H::");
    }

    @Test
    public void when_customer_order_a_coffee_with_2_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.COFFEE, 2, BigDecimal.ZERO);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("C:2:0");
    }

    @Test
    public void display_a_message_then_coffee_machine_send_good_protocol() {
        coffeeMachine.displayMessage("un message");

        verify(drinkMaker).send("M:un message");
    }

    @Test
    public void when_user_oder_a_tea_and_give_30_cents_then_the_drink_maker_should_return_the_string_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 0, BigDecimal.valueOf(0.3));

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("M:It missing 10 cents to buy a tea");
    }


}
