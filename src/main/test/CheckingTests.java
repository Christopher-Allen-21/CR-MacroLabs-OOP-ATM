import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckingTests {

    @Test
    public void depositChecking() {
        //Given
        Checking checking = new Checking();
        checking.depositMoney(10.00);
        double expected = 10.00;

        //When
        double actual = checking.checkBalance();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void zeroBalance() {
        //Given
        Checking checking = new Checking();
        checking.depositMoney(10.00);
        checking.zeroBalance();
        double expected = 0.00;

        //When
        double actual = checking.checkBalance();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void statusFrozen() {
        Checking checking = new Checking();
        checking.changeStatus("Frozen");

        String expected = "FROZEN";
        String actual = checking.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void statusOpen() {
        Checking checking = new Checking();
        checking.changeStatus("oPeN");

        String expected = "OPEN";
        String actual = checking.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawal() {
        Checking checking = new Checking();
        checking.depositMoney(10.00);
        checking.withdraw(5.00);

        double expected = 5.00;
        double actual = checking.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transferFromChecking() {
        Checking checking = new Checking();
        Savings savings = new Savings();
        checking.depositMoney(10.00);
        checking.transferFromChecking(savings, 2.76);

        assertEquals(7.24, checking.checkBalance());
    }

    @Test
    public void checkingAccountNumber() {
        Checking checking = new Checking();
        Integer accountNum = checking.createCheckingAccountNumber();

        assertTrue(accountNum >= 111111 && accountNum <= 333333);
    }

//    @Test
//    public void closeCheckingFalse() {
//        Checking checking = new Checking();
//        checking.depositMoney(20.00);
//
//        assertFalse(checking.closeCheckingAccount());
//    }
//
//    @Test
//    public void closeCheckingTrue() {
//        Checking checking = new Checking();
//        checking.depositMoney(25.62);
//        checking.zeroBalance();
//
//        assertTrue(checking.closeCheckingAccount());
//    }

    @Test
    public void openChecking() {
        Checking checking = new Checking();
        checking.openCheckingAccount();


        assertEquals(0.00, checking.checkBalance());
        assertEquals("Open", checking.getStatus());
    }

    @Test
    public void getAccountNumber() {
        Checking checking = new Checking();
        Integer expected = 000000;

        Integer actual = checking.getAccountNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void transactionHistory() {
        Checking checking = new Checking();
        checking.depositMoney(20.00);

        String expected = "[Deposited $20.0]";

        String actual = checking.getTransactionHistory();

        assertEquals(expected, actual);
    }

    @Test
    public void checkBalance() {
        Checking checking = new Checking();
        checking.depositMoney(20.00);

        double expected = 20.0;

        double actual = checking.checkBalance();

        assertEquals(expected, actual);
    }

    @Test
    void withdrawFromCheckingTest() {
        Checking checking = new Checking();
        Savings savings = new Savings();
        checking.depositMoney(10.00);
        checking.transferFromChecking(savings, 2.76);

        assertEquals(7.24, checking.checkBalance());





    }

}
