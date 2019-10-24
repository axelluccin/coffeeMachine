package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.UserCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCommandUnitTest {
    @Test
    public void when_user_order_a_tea_should_return_T() {
        UserCommand userCommand = new UserCommand(DrinkType.TEA, 0);

        String resultDrink = userCommand.getDrink();

        assertThat(resultDrink).isEqualTo("T");
    }

    @Test
    public void when_user_order_0_sugar_should_return_0() {
        UserCommand userCommand = new UserCommand(DrinkType.TEA, 0);

        String resultSugar = userCommand.getSugar();

        assertThat(resultSugar).isEqualTo("0");
    }
}
