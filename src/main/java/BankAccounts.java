public abstract class BankAccounts {
    double balance = 0.00;
    String status = "Open";


    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double checkBalance() {
        return balance;
    }
    public double depositMoney(double deposit) {
        return balance += deposit;
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    public String transferMoney(Account account1, double moneyToTransfer, Account account2) {
        String outputToUser = "";

    }
    public void amountWithdrawing(double balance, double amountToWithdraw){
        if (balance >= amountToWithdraw);
        balance = balance - amountToWithdraw;

            /* Would like to use this to open new account
             What languages are being used in Justin's associated accounts

            public int openNewAccount(String customerName, double openingBalance) {

            BankAccount b = new BankAccount(customerName, openingBalance);
            accounts[numOfAccounts] = b;
            numOfAccounts++;
            return b.getAccountNum();

                //Close account
            public void closeAccount(int accountNo) {
            accounts[accountNo - 1] = null;
}
                //THIS IS CHECKING IF AN ACCOUNT WAS PREVIOUSLY OPENED, (maybe a good feature to add)
            public int openNewAccount(String customerName, double openingBalance) {
            BankAccount b = new BankAccount(customerName, openingBalance);

            boolean isAccountFound = false;
            int i = 0;
            while(isAccountFound == false && i < accounts.length)
            {
                // if() add conditions for this account to replace the old one.
                // hint: use the isMarkedForDeletion field!
                // Finally add the new value assignment ( accounts[i] = ... )
                // return the account number.
            }
            // This will happen in the case there were no matches.
            accounts[numOfAccounts] = b;
            numOfAccounts++;
            return b.getAccountNum(); */
        }
        }




