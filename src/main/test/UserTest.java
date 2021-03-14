import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UserTest {

    BankAccounts mySavings = new Savings();
    BankAccounts myChecking = new Checking();
    BankAccounts myInvestment = new Investment();
    User user = new User("", "", myChecking, mySavings, myInvestment);

        @Test
        void constructorTest () {
            String expectedUserName = "";
            BankAccounts expectedCheckingAccount = myChecking;
            BankAccounts expectedSavingsAccount = mySavings;
            BankAccounts expectedInvestmentAccount = myInvestment;
            String expectedPassword = "";


            String actualUserName = user.getUserName();
            BankAccounts actualCheckingAccount = user.getCheckingAcct();
            BankAccounts actualSavingsAccount = user.getSavingsAcct();
            BankAccounts actualInvestmentAccount = user.getInvestmentAcct();
            String actualPassword = user.getPassword();

            Assert.assertEquals(expectedUserName, actualUserName);
            Assert.assertEquals(expectedCheckingAccount, actualCheckingAccount);
            Assert.assertEquals(expectedSavingsAccount, actualSavingsAccount);
            Assert.assertEquals(expectedInvestmentAccount, actualInvestmentAccount);
            Assert.assertEquals(expectedPassword, actualPassword);



        }
    }
