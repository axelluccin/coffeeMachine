package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.UserOrder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserOrderUnitTest {
    @Test
    public void when_user_order_a_tea_should_return_T() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 0);

        String resultDrink = userOrder.getDrink();

        assertThat(resultDrink).isEqualTo("T");
    }

    @Test
    public void when_user_order_0_sugar_should_return_0() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 0);

        String resultSugar = userOrder.getSugar();

        assertThat(resultSugar).isEqualTo("0");
    }

    @Test
    public void when_user_order_1_sugar_should_return_1() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1);

        String resultSugar = userOrder.getSugar();

        assertThat(resultSugar).isEqualTo("1");
    }
}
