package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.UserCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCommandUnitTest {
    @Test
    public void when_user_command_a_tea_should_return_T() {
        UserCommand userCommand = new UserCommand(DrinkType.TEA);

        String resultDrink = userCommand.getDrink();

        assertThat(resultDrink).isEqualTo("T");
    }
}
