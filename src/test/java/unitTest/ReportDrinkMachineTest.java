package unitTest;

import coffeeMachine.DrinkType;
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
        List<DrinkType> resultOrders = reportDrinkMachine.Orders();

        assertThat(resultOrders.size()).isEqualTo(0);
    }

    @Test
    public void when_one_orders_in_coffee_machine_then_report_return_1_order() {
        reportDrinkMachine.add(DrinkType.COFFEE);

        List<DrinkType> resultOrders = reportDrinkMachine.Orders();

        assertThat(resultOrders.size()).isEqualTo(1);
    }

    @Test
    public void when_2_orders_of_coffee_and_1_order_of_chocolate_then_report_return_2_orders() {
        reportDrinkMachine.add(DrinkType.CHOCOLATE);
        reportDrinkMachine.add(DrinkType.COFFEE);
        reportDrinkMachine.add(DrinkType.COFFEE);

        int resultOrdersCoffee = reportDrinkMachine.OrdersOfType(DrinkType.COFFEE);

        assertThat(resultOrdersCoffee).isEqualTo(2);
    }

    @Test
    public void when_2_orders_of_coffee_and_2_orders_of_chocolate_then_report_return_the_message() {
        reportDrinkMachine.add(DrinkType.COFFEE);
        reportDrinkMachine.add(DrinkType.COFFEE);
        reportDrinkMachine.add(DrinkType.CHOCOLATE);
        reportDrinkMachine.add(DrinkType.CHOCOLATE);

        String resultReportOrders = reportDrinkMachine.reportMessage();

        assertThat(resultReportOrders).isEqualTo("0 tea, 2 chocolate, 2 coffee, 0 orange, money earned: 2.2 dollars");
    }
}
