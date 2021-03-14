import java.util.ArrayList;

public abstract class BankAccounts {
    double balance;
    String status;
    ArrayList<Integer> accountNumbersInUse = new ArrayList<Integer>();
    ArrayList<String> transactionList = new ArrayList<String>();


    public void zeroBalance() {
        this.balance = 0.00;
    }

    public double checkBalance() {
        return balance;
    }

    public double depositMoney(double deposit) {
        balance += deposit;
        transactionList.add("Deposited $" + deposit);
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
            transactionList.add("Withdrew $" + amountToWithdraw);
            enoughFunds = true;
        }
        return enoughFunds;
    }

    public String getTransactionHistory() {
        String printedList = transactionList.toString();
        return printedList;
    }



}




