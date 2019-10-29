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
        UserOrder userOrder = new UserOrder(DrinkType.TEA, 1, BigDecimal.ZERO, false);

        String resultProtocol = protocolDrinkMaker.formatToDrinkMaker(userOrder);

        assertThat(resultProtocol).isEqualTo("T:1:0");
    }

    @Test
    public void when_display_that_it_is_missing_money_to_buy_a_tea_user_then_protocol_drink_maker_should_format_the_message() {
        String resultProtocolDrinkMaker = protocolDrinkMaker.formatMissingMoney(BigDecimal.valueOf(0.1), DrinkType.TEA.getDrinkName());

        assertThat(resultProtocolDrinkMaker).isEqualTo("M:It is missing 0.1 dollars to buy a tea");
    }

    @Test
    public void when_display_that_it_is_missing_money_to_buy_a_chocolate_to_user_then_protocol_drink_maker_should_format_the_message() {
        String resultProtocolDrinkMaker = protocolDrinkMaker.formatMissingMoney(BigDecimal.valueOf(0.2), DrinkType.CHOCOLATE.getDrinkName());

        assertThat(resultProtocolDrinkMaker).isEqualTo("M:It is missing 0.2 dollars to buy a chocolate");
    }

    @Test
    public void when_display_that_it_is_missing_money_to_buy_a_coffee_to_user_then_protocol_drink_maker_should_format_the_message() {
        String resultProtocolDrinkMaker = protocolDrinkMaker.formatMissingMoney(BigDecimal.valueOf(0.3), DrinkType.COFFEE.getDrinkName());

        assertThat(resultProtocolDrinkMaker).isEqualTo("M:It is missing 0.3 dollars to buy a coffee");
    }

    @Test
    public void when_display_that_it_is_missing_money_to_buy_a_orange_to_user_then_protocol_drink_maker_should_format_the_message() {
        String resultProtocolDrinkMaker = protocolDrinkMaker.formatMissingMoney(BigDecimal.valueOf(0.30), DrinkType.ORANGE.getDrinkName());

        assertThat(resultProtocolDrinkMaker).isEqualTo("M:It is missing 0.3 dollars to buy a orange");
    }

    @Test
    public void when_user_order_a_coffee_extra_hot_then_protocol_drink_maker_should_format_the_good_protocol() {
        UserOrder userOrder = new UserOrder(DrinkType.COFFEE, 0, BigDecimal.ZERO, true);

        String resultProtocolDrinkMaker = protocolDrinkMaker.formatToDrinkMaker(userOrder);

        assertThat(resultProtocolDrinkMaker).isEqualTo("Ch::");
    }
}