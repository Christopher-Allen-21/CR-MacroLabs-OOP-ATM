import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class User {


    private String firstName = "";
   private String lastName = "";
   private byte password[];
   public BankAccounts checking = new Checking();
   public BankAccounts savings = new Savings();
   public BankAccounts investment = new Investment();


   public User(String firstName, String lastName,  String password, BankAccounts checking, BankAccounts savings, BankAccounts investment) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.checking = checking;
       this.savings = savings;
       this.investment = investment;




       try {
           MessageDigest md = MessageDigest.getInstance("MD5");
           this.password= md.digest(password.getBytes());
       } catch (NoSuchAlgorithmException e) {
           System.err.println("error, caught");
           e.printStackTrace();
           System.exit(1);

       }
   }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public String[] getAccountNumber() {
        return accountNumber;
    }*/





}
