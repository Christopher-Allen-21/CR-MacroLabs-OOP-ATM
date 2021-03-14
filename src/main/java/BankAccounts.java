public abstract class BankAccounts {
    double balance;
    String status;


    public void zeroBalance() {
        this.balance = 0.00;
    }

    public double checkBalance() {
        return balance;
    }

    public double depositMoney(double deposit) {
        balance += deposit;
        return checkBalance();
    }


    //ATM can handle what user can do if frozen or not
    public void changeStatus(String newStatus) {
        if (newStatus.equalsIgnoreCase("frozen") || newStatus.equalsIgnoreCase("open")) {
            this.status = newStatus.toUpperCase();
        }
    }

    public String getStatus() {
        return this.status;
    }


    public boolean withdraw(double amountToWithdraw) {
        boolean enoughFunds = false;
        double currentBalance = checkBalance();
        if (currentBalance >= amountToWithdraw) {
            currentBalance -= amountToWithdraw;
            this.balance = Math.round(currentBalance * 100.00) / 100.00;
            enoughFunds = true;
        }
        return enoughFunds;
    }

}




