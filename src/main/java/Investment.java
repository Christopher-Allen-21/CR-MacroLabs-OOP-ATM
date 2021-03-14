

public class Investment extends BankAccounts{
    Integer accountNumber;

    public boolean transferFromInvestments(BankAccounts accTransferTo, double amountToTransfer) {
        boolean enoughFunds = false;
        double checkingBalance = checkBalance();
        if (checkingBalance > amountToTransfer) {
            accTransferTo.depositMoney(amountToTransfer);
            withdraw(amountToTransfer);
            enoughFunds = true;
        }
        return enoughFunds;
    }

    public Integer createInvestmentAccountNumber() {
        accountNumber = 666667 + (int) (Math.random() * ((999999 - 666667) + 1));
        return accountNumber;
    }

    public boolean accountNumbAlreadyExists(Integer newAccountNum) {
        for (Integer accountNum : accountNumbersInUse) {
            if (accountNum != newAccountNum) {
                return false;
            }
        }
        return true;
    }

    public void setAccountNumber() {
        Integer accountNum = createInvestmentAccountNumber();
        if (!accountNumbAlreadyExists(accountNum)) {
            accountNumber = accountNum;
            accountNumbersInUse.add(accountNum);
        }
    }

    public void openInvestmentAccount() {
        setAccountNumber();
        balance = 0.00;
        status = "Open";
    }

    public boolean closeInvestmentAccount() {
        boolean isClosed = false;
        if (checkBalance() == 0.00) {
            changeStatus("Closed");
            isClosed = true;
        }
        return isClosed;
    }

    @Override
    public String toString() {
        return "Investment";
    }
}
