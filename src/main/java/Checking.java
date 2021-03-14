public class Checking extends BankAccounts{
    Checking checking = new Checking();

    public boolean transferFromChecking(BankAccounts accTransferTo, double amountToTransfer) {
        boolean enoughFunds = false;
        double checkingBalance = checking.checkBalance();
        if (checkingBalance > amountToTransfer) {
            accTransferTo.depositMoney(amountToTransfer);
            checking.withdraw(amountToTransfer);
            enoughFunds = true;
        }
        return enoughFunds;
    }

    public Integer createCheckingAccountNumber() {
        Integer accountNumber = 111111 + (int) (Math.random() * ((333333 - 111111) + 1));
        return accountNumber;
    }
}
