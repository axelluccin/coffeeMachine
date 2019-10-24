package acceptanceTest;

import coffeeMachine.CoffeeMachine;
import coffeeMachine.DrinkType;
import coffeeMachine.UserOrder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeMachineAcceptanceTest {
    @Test
    public void when_customer_order_a_tea_with_sugar_then_coffee_machine_return_the_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 0);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String resultCommand = coffeeMachine.command(userOrder);

        assertThat(resultCommand).isEqualTo("T:1:0");
    }
}
