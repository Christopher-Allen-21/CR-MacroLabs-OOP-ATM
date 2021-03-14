import java.util.ArrayList;

public class Checking extends BankAccounts{
    Integer accountNumber;
    ArrayList<Integer> accountNumbersInUse = new ArrayList<Integer>();

    public boolean transferFromChecking(BankAccounts accTransferTo, double amountToTransfer) {
        boolean enoughFunds = false;
        double checkingBalance = checkBalance();
        if (checkingBalance > amountToTransfer) {
            accTransferTo.depositMoney(amountToTransfer);
            withdraw(amountToTransfer);
            enoughFunds = true;
        }
        return enoughFunds;
    }

    public Integer createCheckingAccountNumber() {
        accountNumber = 111111 + (int) (Math.random() * ((333333 - 111111) + 1));
        return accountNumber;
    }

    public boolean accountNumAlreadyExist(Integer newAccountNum) {
        for (Integer accountNum : accountNumbersInUse) {
            if (accountNum != newAccountNum) {
                return false;
            }
        }
        return true;
    }

    public void setAccountNumber() {
        Integer accountNum = createCheckingAccountNumber();
        if (!accountNumAlreadyExist(accountNum)) {
            accountNumber = accountNum;
            accountNumbersInUse.add(accountNum);
        }
    }

    public void openCheckingAccount() {
        setAccountNumber();
        balance = 0.00;
    }

    public boolean closeCheckingAccount() {
        boolean isClosed = false;
        if (checkBalance() == 0.00) {
            changeStatus("Closed");
            isClosed = true;
        }
        return isClosed;
    }

    @Override
    public String toString() {
        return "Checking";
    }
}
