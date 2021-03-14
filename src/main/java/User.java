import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class User {
   private String userName = "";
   private String password;
   public BankAccounts checkingAcct = new Checking();
   public BankAccounts savingsAcct = new Savings();
   public BankAccounts investmentAcct = new Investment();


   public User(String userName,  String password, BankAccounts checking, BankAccounts savings, BankAccounts investment) {
       this.userName = userName;
       this.checkingAcct = checking;
       this.savingsAcct = savings;
       this.investmentAcct = investment;
       this.password = password;

   }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword(){
       return password;
    }

    /*public String[] getAccountNumber() {
        return accountNumber;
    }*/





}
