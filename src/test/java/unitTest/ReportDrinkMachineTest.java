package unitTest;

import coffeeMachine.DrinkType;
import coffeeMachine.ReportDrinkMachine;
import coffeeMachine.UserOrder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportDrinkMachineTest {
    private ReportDrinkMachine reportDrinkMachine;

    @Before
    public void setUp() throws Exception {
        reportDrinkMachine = new ReportDrinkMachine();
    }

    @Test
    public void when_no_order_in_coffee_machine() {
        List<UserOrder> resultOrders = reportDrinkMachine.Orders();

        assertThat(resultOrders.size()).isEqualTo(0);
    }

    @Test
    public void when_one_orders_in_coffee_machine_then_report_return_1_order() {
        UserOrder order = new UserOrder(DrinkType.COFFEE, 0, BigDecimal.ZERO, false);
        reportDrinkMachine.add(order);

        List<UserOrder> resultOrders = reportDrinkMachine.Orders();

        assertThat(resultOrders.size()).isEqualTo(1);
    }

    @Test
    public void when_2_orders_of_coffee_and_1_order_of_chocolate_then_report_return_2_orders() {
        UserOrder orderCoffee = new UserOrder(DrinkType.COFFEE, 0, BigDecimal.ZERO, false);
        UserOrder orderChocolate = new UserOrder(DrinkType.CHOCOLATE, 0, BigDecimal.ZERO, false);

        reportDrinkMachine.add(orderChocolate);
        reportDrinkMachine.add(orderCoffee);
        reportDrinkMachine.add(orderCoffee);

        int resultOrdersCoffee = reportDrinkMachine.OrdersOfType(DrinkType.COFFEE);
        assertThat(resultOrdersCoffee).isEqualTo(2);
    }
}
