package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.ProtocolDrinkMaker;
import coffeeMachine.UserOrder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtocolDrinkMakerTest {

    private ProtocolDrinkMaker protocolDrinkMaker;

    @Before
    public void setUp() throws Exception {
        protocolDrinkMaker = new ProtocolDrinkMaker();
    }

    @Test
    public void when_user_order_a_tea_with_a_sugar_protocol_drink_maker_should_return_the_string_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1, BigDecimal.ZERO);

        String resultProtocol = protocolDrinkMaker.format(userOrder);

        assertThat(resultProtocol).isEqualTo("T:1:0");
    }

    @Test
    public void when_display_message_to_user_then_protocol_drink_maker_should_return_the_string_protocol() {
        String message = "le message";

        String resultProtocol = protocolDrinkMaker.format(message);

        assertThat(resultProtocol).isEqualTo("M:le message");
    }

    @Test
    public void when_display_that_it_is_missing_money_to_user_then_protocol_drink_maker_should_format_the_message() {
        String resultProtocolDrinkMaker = protocolDrinkMaker.format(BigDecimal.valueOf(0.1), DrinkType.TEA);

        assertThat(resultProtocolDrinkMaker).isEqualTo("M:It is missing 0.1 dollars to buy a tea");
    }
}