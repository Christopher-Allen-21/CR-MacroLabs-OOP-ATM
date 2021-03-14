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
        return accountNumber;
    }
}
