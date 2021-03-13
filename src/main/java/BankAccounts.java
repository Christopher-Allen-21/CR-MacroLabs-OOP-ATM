public abstract class BankAccounts {
    User currentUser = new User();
    //Is that^^^ needed?

    double balance = 0.00;
    String status = "Open";


    public void setBalance(double balance) {
        this.balance = balance;
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

    //psuedo
    public String transferMoney(Account account1, double moneyToTransfer, Account account2) {
        /*
        Needs to take in User account info of account losing money
        Take in User account that will gain the money
        Amount of Money to transfer
         */
        /*
            Subtract from first account, add to second account, only if it won't overdraft
         */
        String outputToUser = "";
        if (account1 < moneyToTransfer) {
            outputToUser += "Insufficient funds";
        } else {
            account1 -= moneyToTransfer;
            account2 += moneyToTransfer;
            outputToUser += "Transfer of $" + moneyToTransfer + " completed";
        }
        return outputToUser;

    }

    public void amountWithdrawing(double balance, double amountToWithdraw) {
        if (balance >= amountToWithdraw) ;
        balance = balance - amountToWithdraw;
    }

    //compare withdrawal methods
    /*public void withdraw(double amountToWithdraw) {
        double currentBalance = checkBalance();
        if (currentBalance >= amountToWithdraw) {
            currentBalance -= amountToWithdraw;
            setBalance(currentBalance);
        }
    }*/


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




