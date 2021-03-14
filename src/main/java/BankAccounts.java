public abstract class BankAccounts {
    double balance;
    String status;


    public void zeroBalance() {
        this.balance = 0.00;
    }

    public double checkBalance() {
        return balance;
    }

    public void depositMoney(double deposit) {
        balance += deposit;
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    /*public void amountWithdrawing(double balance, double amountToWithdraw) {
        if (balance >= amountToWithdraw) ;
        balance = balance - amountToWithdraw;
    }*/

    //compare withdrawal methods
    public void withdraw(double amountToWithdraw) {
        double currentBalance = checkBalance();
        if (currentBalance >= amountToWithdraw) {
            currentBalance -= amountToWithdraw;
            this.balance = currentBalance;
        }
    }


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
            return b.getAccountNum();
    }*/
}




