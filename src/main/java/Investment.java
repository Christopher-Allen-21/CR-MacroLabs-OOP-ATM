public class Investment extends BankAccounts{
    Investment investment = new Investment();

    public boolean transferFromInvestments(BankAccounts accTransferTo, double amountToTransfer) {
        boolean enoughFunds = false;
        double checkingBalance = investment.checkBalance();
        if (checkingBalance > amountToTransfer) {
            accTransferTo.depositMoney(amountToTransfer);
            investment.withdraw(amountToTransfer);
            enoughFunds = true;
        }
        return enoughFunds;
    }

    public Integer createInvestmentAccountNumber() {
        Integer accountNumber = 666667 + (int) (Math.random() * ((999999 - 666667) + 1));
        return accountNumber;
    }
}
