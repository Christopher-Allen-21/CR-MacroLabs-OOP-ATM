

public class Savings extends BankAccounts{
    Integer accountNumber;

    public boolean transferFromSavings(BankAccounts accTransferTo, double amountToTransfer) {
        boolean enoughFunds = false;
        double checkingBalance = checkBalance();
        if (checkingBalance > amountToTransfer) {
            accTransferTo.depositMoney(amountToTransfer);
            withdraw(amountToTransfer);
            enoughFunds = true;
        }
        return enoughFunds;
    }

    public Integer createSavingsAccountNumber() {
        accountNumber = 333334 + (int) (Math.random() * ((666666 - 333334) + 1));
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
        Integer accountNum = createSavingsAccountNumber();
        if (!accountNumAlreadyExist(accountNum)) {
            accountNumber = accountNum;
            accountNumbersInUse.add(accountNum);
        }
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void openSavingsAccount() {
        setAccountNumber();
        balance = 0.00;
        status = "Open";
    }

    public boolean closeSavingsAccount() {
        boolean isClosed = false;
        if (checkBalance() == 0.00) {
            changeStatus("Closed");
            accountNumbersInUse.remove(getAccountNumber());
            isClosed = true;
        }
        return isClosed;
    }

    @Override
    public String toString() {
        return "Savings";
    }
}
