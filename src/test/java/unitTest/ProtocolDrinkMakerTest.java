package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.ProtocolDrinkMaker;
import coffeeMachine.UserOrder;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtocolDrinkMakerTest {

    private ProtocolDrinkMaker protocolDrinkMaker;

    @Before
    public void setUp() throws Exception {
        protocolDrinkMaker = new ProtocolDrinkMaker();
    }

    @Test
    public void when_user_order_a_tea_with_a_sugar_protocol_drink_maker_should_return_the_string_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1);

        String resultProtocol = protocolDrinkMaker.format(userOrder);

        assertThat(resultProtocol).isEqualTo("T:1:0");
    }

    @Test
    public void when_display_message_to_user_then_protocol_drink_maker_should_return_the_string_protocol() {
        String resultProtocol = protocolDrinkMaker.format("le message");

        assertThat(resultProtocol).isEqualTo("M:le message");
    }
}