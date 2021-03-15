import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountsTest {

    @Test
    public void transfer() {
        ATM atm = new ATM();
        BankAccounts checkingAcct = new Checking();
        BankAccounts savingsAcct = new Savings();
        BankAccounts investmentAcct = new Investment();
        BankAccounts checkingAcct2 = new Checking();
        BankAccounts savingsAcct2 = new Savings();
        BankAccounts investmentAcct2 = new Investment();
        User currentUser = new User("billy", "password123", checkingAcct, savingsAcct, investmentAcct);
        User currentUser2 = new User("sean", "password123", checkingAcct2, savingsAcct2, investmentAcct2);
        currentUser.getCheckingAcct().depositMoney(20);

        atm.transferExternalAccountScreen(currentUser, checkingAcct, 20, currentUser2);

        double expectedBilly = 0.0;
        double expectedSean = 20.00;

        double actualBilly = currentUser.getCheckingAcct().checkBalance();
        double actualSean = currentUser2.getCheckingAcct().checkBalance();

        Assertions.assertEquals(expectedBilly, actualBilly);
        Assertions.assertEquals(expectedSean, actualSean);

    }
}
