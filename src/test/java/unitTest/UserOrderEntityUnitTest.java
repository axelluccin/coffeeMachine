package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.Order;
import coffeeMachine.UserOrderEntity;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class UserOrderEntityUnitTest {
    @Test
    public void when_user_order_a_tea_should_return_T() {
        Order order = new Order(DrinkType.TEA, 0, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultDrink = userOrderEntity.getDrinkProtocol();

        assertThat(resultDrink).isEqualTo("T");
    }

    @Test
    public void when_user_order_0_sugar_should_return_empty_string() {
        Order order = new Order(DrinkType.TEA, 0, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultSugar = userOrderEntity.getSugar();

        assertThat(resultSugar).isEqualTo("");
    }

    @Test
    public void when_user_order_1_sugar_should_return_1() {
        Order order = new Order(DrinkType.TEA, 1, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultSugar = userOrderEntity.getSugar();

        assertThat(resultSugar).isEqualTo("1");
    }

    @Test
    public void when_user_order_1_sugar_should_return_0_stick() {
        Order order = new Order(DrinkType.TEA, 1, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultStick = userOrderEntity.getStick();

        assertThat(resultStick).isEqualTo("0");
    }

    @Test
    public void when_user_order_0_sugar_should_return_no_stick() {
        Order order = new Order(DrinkType.TEA, 0, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultStick = userOrderEntity.getStick();

        assertThat(resultStick).isEqualTo("");
    }

    @Test
    public void when_user_order_a_chocolate_should_return_H() {
        Order order = new Order(DrinkType.CHOCOLATE, 0, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);
        String resultDrink = userOrderEntity.getDrinkProtocol();

        assertThat(resultDrink).isEqualTo("H");
    }

    @Test
    public void when_user_order_a_coffee_then_the_drink_should_return_C() {
        Order order = new Order(DrinkType.COFFEE, 0, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultDrink = userOrderEntity.getDrinkProtocol();

        assertThat(resultDrink).isEqualTo("C");
    }

    @Test
    public void when_user_order_a_tea_with_30_cents_then_price_compare_should_return_10() {
        Order order = new Order(DrinkType.TEA, 0, BigDecimal.valueOf(0.30), false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        BigDecimal resultPriceCompare = userOrderEntity.priceCompare();

        assertThat(resultPriceCompare).isEqualTo(BigDecimal.valueOf(0.10));
    }


    @Test
    public void when_user_order_a_tea_with_40_cents_then_price_compare_should_return_0() {
        Order order = new Order(DrinkType.TEA, 0, BigDecimal.valueOf(0.40), false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        BigDecimal resultPriceCompare = userOrderEntity.priceCompare();

        assertThat(resultPriceCompare).isEqualTo(BigDecimal.valueOf(0.0));
    }

    @Test
    public void when_user_order_a_chocolate_with_50_cents_then_price_compare_should_return_0() {
        Order order = new Order(DrinkType.CHOCOLATE, 0, BigDecimal.valueOf(0.50), false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        BigDecimal resultPriceCompare = userOrderEntity.priceCompare();

        assertThat(resultPriceCompare).isEqualTo(BigDecimal.valueOf(0.0));
    }

    @Test
    public void when_user_order_a_coffee_with_60_cents_then_price_compare_should_return_0() {
        Order order = new Order(DrinkType.COFFEE, 0, BigDecimal.valueOf(0.60), false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        BigDecimal resultPriceCompare = userOrderEntity.priceCompare();

        assertThat(resultPriceCompare).isEqualTo(BigDecimal.valueOf(0.0));
    }

    @Test
    public void when_user_order_a_orange_then_the_drink_protocol_should_return_C() {
        Order order = new Order(DrinkType.ORANGE, 0, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);
        String resultDrink = userOrderEntity.getDrinkProtocol();

        assertThat(resultDrink).isEqualTo("O");
    }

    @Test
    public void when_user_order_a_orange_with_60_cents_then_price_compare_should_return_0() {
        Order order = new Order(DrinkType.ORANGE, 0, BigDecimal.valueOf(0.60), false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        BigDecimal resultPriceCompare = userOrderEntity.priceCompare();

        assertThat(resultPriceCompare).isEqualTo(BigDecimal.valueOf(0.0));
    }

    @Test
    public void when_user_order_a_coffee_extra_hot_then_should_return_h() {
        Order order = new Order(DrinkType.COFFEE, 0, BigDecimal.valueOf(0.60), true);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultDrinkHot = userOrderEntity.drinkHot();

        assertThat(resultDrinkHot).isEqualTo("h");
    }

    @Test
    public void when_user_order_a_coffee_not_hot_then_should_return_nothing() {
        Order order = new Order(DrinkType.COFFEE, 0, BigDecimal.ZERO, false);
        UserOrderEntity userOrderEntity = new UserOrderEntity(order);

        String resultHotDrink = userOrderEntity.drinkHot();

        assertThat(resultHotDrink).isEqualTo("");
    }
}
