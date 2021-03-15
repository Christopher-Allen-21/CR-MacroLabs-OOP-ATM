import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void investmentAccountNum() {
        Investment investment = new Investment();
        Integer investmentNum = investment.createInvestmentAccountNumber();

        assertTrue(investmentNum >= 666667 && investmentNum <= 999999);
    }

//    @Test
//    public void closeInvestmentTrue() {
//        Investment investment = new Investment();
//        investment.depositMoney(25.38);
//        investment.zeroBalance();
//
//        assertTrue(investment.closeInvestmentAccount());
//    }
//
//    @Test
//    public void closeInvestmentFalse() {
//        Investment investment = new Investment();
//        investment.depositMoney(49.36);
//
//        assertFalse(investment.closeInvestmentAccount());
//    }

    @Test
    public void openInvestment() {
        Investment investment = new Investment();
        investment.openInvestmentAccount();


        assertEquals(0.00, investment.checkBalance());
        assertEquals("Open", investment.getStatus());
    }

    @Test
    public void getAccountNum() {
        Investment investment = new Investment();
        Integer expected = 000000;

        Integer actual = investment.getAccountNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void checkBalance() {
        Investment investment = new Investment();
        investment.depositMoney(15.64);

        double expected = 15.64;
        double actual = investment.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transactionHistory() {
        Investment investment = new Investment();
        investment.depositMoney(2.56);
        investment.withdraw(1.15);

        String expected = "[Deposited $2.56, Withdrew $1.15]";
        String actual = investment.getTransactionHistory();

        assertEquals(expected, actual);
    }
}
