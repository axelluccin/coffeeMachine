package acceptanceTest;

import coffeeMachine.CoffeeMachine;
import coffeeMachine.DrinkType;
import coffeeMachine.UserOrder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeMachineAcceptanceTest {
    @Test
    public void when_customer_order_a_tea_with_sugar_then_coffee_machine_return_the_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String resultCommand = coffeeMachine.order(userOrder);

        assertThat(resultCommand).isEqualTo("T:1:0");
    }

    @Test
    public void when_customer_order_a_chocolate_with_no_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.CHOCOLATE, 0);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String resultOrder = coffeeMachine.order(userOrder);

        assertThat(resultOrder).isEqualTo("H::");
    }

    @Test
    public void when_customer_order_a_coffee_with_2_sugar_then_the_coffee_machine_send_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.COFFEE, 2);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String resultOrder = coffeeMachine.order(userOrder);

        assertThat(resultOrder).isEqualTo("C:2:0");
    }

    @Test
    public void display_a_message_then_coffee_machine_send_good_protocol() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String resultOrder = coffeeMachine.displayMessage("un message");

        assertThat(resultOrder).isEqualTo("M:un message");
    }
}
