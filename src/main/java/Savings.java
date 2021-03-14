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
        /*
        if accountNumber is equal to that of one in archives, generate again
        recursion here? Call itself until it gets a unique number?
         */
        return accountNumber;
    }

    public void openSavingsAccount() {
        createSavingsAccountNumber();
        balance = 0.00;
    }

    @Override
    public String toString(){
        return "Savings";
    }
}
