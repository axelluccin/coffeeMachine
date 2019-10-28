package unitTest;

import coffeeMachine.Order;
import coffeeMachine.ReportDrinkMachine;
import org.junit.Before;
import org.junit.Test;

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
        List<Order> resultOrders = reportDrinkMachine.Orders();

        assertThat(resultOrders.size()).isEqualTo(0);
    }

    @Test
    public void when_one_orders_in_coffee_machine() {
        Order order = new Order();
        reportDrinkMachine.add(order);

        List<Order> resultOrders = reportDrinkMachine.Orders();

        assertThat(resultOrders.size()).isEqualTo(1);
    }
}
