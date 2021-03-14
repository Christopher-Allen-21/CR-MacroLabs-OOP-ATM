public class Investment extends BankAccounts{

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
        Integer accountNumber = 666667 + (int) (Math.random() * ((999999 - 666667) + 1));
        /*
        if accountNumber is equal to that of one in archives, generate again
        recursion here? Call itself until it gets a unique number?
         */
        return accountNumber;
    }

    public void openInvestmentAccount() {
        createInvestmentAccountNumber();
        balance = 0.00;
    }
}
