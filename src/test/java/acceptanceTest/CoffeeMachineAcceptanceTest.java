package acceptanceTest;

import coffeeMachine.*;
import org.junit.Before;
import org.junit.Test;

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
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("T:1:0");
    }

    @Test
    public void when_customer_order_a_chocolate_with_no_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.CHOCOLATE, 0);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("H::");
    }

    @Test
    public void when_customer_order_a_coffee_with_2_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.COFFEE, 2);

        coffeeMachine.order(userOrder);

        verify(drinkMaker).send("C:2:0");
    }

    @Test
    public void display_a_message_then_coffee_machine_send_good_protocol() {
        coffeeMachine.displayMessage("un message");

        verify(drinkMaker).send("M:un message");
    }
}
