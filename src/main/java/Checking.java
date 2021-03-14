public class Checking extends BankAccounts{


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

    public static Integer createCheckingAccountNumber() {
        Integer accountNumber = 111111 + (int) (Math.random() * ((333333 - 111111) + 1));
        /*
        if accountNumber is equal to that of one in archives, generate again
        recursion here? Call itself until it gets a unique number?
         */
        return accountNumber;
    }

    public void openCheckingAccount() {
        Checking.createCheckingAccountNumber();
        balance = 0.00;
    }

    public void closeCheckingAccount() {
        if (checkBalance() == 0.00) {

        }
    }
}
