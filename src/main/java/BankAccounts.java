import java.util.ArrayList;

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

}
