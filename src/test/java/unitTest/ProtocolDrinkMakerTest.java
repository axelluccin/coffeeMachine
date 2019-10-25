package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.ProtocolDrinkMaker;
import coffeeMachine.UserOrder;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ProtocolDrinkMakerTest {

    private ProtocolDrinkMaker protocolDrinkMaker;

    @Before
    public void setUp() throws Exception {
        protocolDrinkMaker = new ProtocolDrinkMaker();
    }

    @Test
    public void when_user_order_a_tea_with_a_sugar_should_return_the_string_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1);

        String resultProtocol = protocolDrinkMaker.format(userOrder);

        Assertions.assertThat(resultProtocol).isEqualTo("T:1:0");
    }


}