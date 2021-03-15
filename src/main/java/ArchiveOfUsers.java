import java.util.ArrayList;

public class ArchiveOfUsers {
    BankAccounts myChecking1 = new Checking();
    BankAccounts mySavings1 = new Savings();
    BankAccounts myInvestment1 = new Investment();
    BankAccounts myChecking2 = new Checking();
    BankAccounts mySavings2 = new Savings();
    BankAccounts myInvestment2 = new Investment();
    BankAccounts myChecking3 = new Checking();
    BankAccounts mySavings3 = new Savings();
    BankAccounts myInvestment3 = new Investment();
    BankAccounts myChecking4 = new Checking();
    BankAccounts mySavings4 = new Savings();
    BankAccounts myInvestment4 = new Investment();

    ArrayList<User> userList = new ArrayList<User>();

    public ArchiveOfUsers(){
        User user1 = new User("Chris Allen","password123",myChecking1,mySavings1,myInvestment1);
        User user2 = new User("Justin Banks","password123",myChecking2,mySavings2,myInvestment2);
        User user3 = new User("Greg Donnelly","password123",myChecking3,mySavings3,myInvestment3);
        User user4 = new User("Ashley Smart","password123",myChecking4,mySavings4,myInvestment4);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
    }

    public boolean checkForExistingUser(String name){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getUserName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public int getUserIndex(String name){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getUserName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    public User getArchivedUser(int index){
        return userList.get(index);
    }

    public void deleteAccount(User currentUser) {
        userList.remove(currentUser);
    }

    public User openAccount(String name) {
        BankAccounts newChecking = new Checking();
        BankAccounts newSavings = new Savings();
        BankAccounts newInvestment = new Investment();
        User newUser = new User(name,"password123",newChecking,newSavings,newInvestment);
        userList.add(newUser);
        return newUser;
    }
}
