public class Savings extends BankAccounts{

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
        Integer accountNumber = 333334 + (int) (Math.random() * ((666666 - 333334) + 1));
        return accountNumber;
    }
}
