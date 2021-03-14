import java.util.ArrayList;

public class ArchiveOfUsers {
    BankAccounts myChecking = new Checking();
    BankAccounts mySavings = new Savings();
    BankAccounts myInvestment = new Investment();
    ArrayList<User> userList = new ArrayList<User>();

    public ArchiveOfUsers(){
        User user1 = new User("Chris Allen","password123",myChecking,mySavings,myInvestment);
        User user2 = new User("Justin Banks","password123",myChecking,mySavings,myInvestment);
        User user3 = new User("Greg Donnelly","password123",myChecking,mySavings,myInvestment);
        User user4 = new User("Ashley Smart","password123",myChecking,mySavings,myInvestment);

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
}
