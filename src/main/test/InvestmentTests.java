import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class InvestmentTests {

    @Test
    public void depositInvestment() {
        Investment investment = new Investment();
        investment.depositMoney(65.15);
        double expected = 65.15;

        double actual = investment.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void zeroBalance() {
        Investment investment = new Investment();
        investment.depositMoney(981.27);
        double expected = 0.00;

        investment.zeroBalance();
        double actual = investment.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void statusFrozen() {
        Investment investment = new Investment();
        investment.changeStatus("FroZeN");

        String expected = "FROZEN";
        String actual = investment.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void statusOpen() {
        Investment investment = new Investment();
        investment.changeStatus("OPeN");

        String expected = "OPEN";
        String actual = investment.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawal() {
        Investment investment = new Investment();
        investment.depositMoney(15.34);
        investment.withdraw(4.12);

        double expected = 11.22;
        double actual = investment.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transferFromInvestment() {
        Investment investment = new Investment();
        Savings savings = new Savings();
        investment.depositMoney(67.05);

        investment.transferFromInvestments(savings, 16.54);

        assertEquals(50.51, investment.checkBalance());
    }
}
