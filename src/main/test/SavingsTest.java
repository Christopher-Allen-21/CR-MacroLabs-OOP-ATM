import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SavingsTest {

    @Test
    public void depositSavings() {
        Savings savings = new Savings();
        savings.depositMoney(7.00);
        double expected = 7.00;

        double actual = savings.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void zeroBalance() {
        Savings savings = new Savings();
        savings.depositMoney(7.00);
        double expected = 0.00;

        savings.zeroBalance();
        double actual = savings.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void statusFrozen() {
        Savings savings = new Savings();
        savings.changeStatus("frOzEn");

        String expected = "FROZEN";
        String actual = savings.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void statusOpen() {
        Savings savings = new Savings();
        savings.changeStatus("OpeN");

        String expected = "OPEN";
        String actual = savings.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawal() {
        Savings savings = new Savings();
        savings.depositMoney(12.00);
        savings.withdraw(4.50);

        double expected = 7.50;
        double actual = savings.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transferFromSavings() {
        Savings savings = new Savings();
        Investment investment = new Investment();
        savings.depositMoney(21.00);

        savings.transferFromSavings(investment, 5.62);

        assertEquals(15.38, savings.checkBalance());
    }
}
