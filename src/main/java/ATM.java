public class ATM {

    //User currentUser = new User();
    String tempPassword = "password123";

    public void run(){

        Console.displayUserNamePrompt();
        String userName = Console.getStringInput();

        while(true){
            if(userName.equals("99")){
                System.exit(0);
            }
            else{
                passwordPromptScreen(userName);
            }
        }
    }

    public void passwordPromptScreen(String userName){
        Console.displayPasswordPrompt(userName);

        while(true){
            String password = Console.getStringInput();
            if(password.equals(tempPassword)){ //    if(password == currentUser.getPassword())
                selectAccountScreen(userName);
            }
            else if(password.equals("00")){
                run();
            }
            else if(password.equals("99")){
                System.exit(0);
            }
            else{
                Console.displayInvalidPasswordPrompt(userName);
            }

        }
    }

    public void selectAccountScreen(String userName){
        Console.displaySelectAccountScreen(userName);

        while(true){
            String accountSelection = Console.getStringInput();

            if(accountSelection.equals("1")){
                accountOptionsScreen(userName,"Savings");
            }
            else if(accountSelection.equals("2")){
                accountOptionsScreen(userName,"Checking");
            }
            else if(accountSelection.equals("3")){
                accountOptionsScreen(userName,"Investment");
            }
            else if(accountSelection.equals("00")){
                run();
            }
            else if(accountSelection.equals("99")){
                System.exit(0);
            }
            else{
                Console.displayInvalidSelectAccountScreen(userName);
            }
        }
    }

    public void accountOptionsScreen(String userName,String accountType) {
        Console.displayAccountOptionsScreen(userName,accountType);

        while(true){
            String acctOptionSelection = Console.getStringInput();
            if(acctOptionSelection.equals("1")){
                System.out.println("Option 1"); // currentUser.checkBalance()
            }
            else if(acctOptionSelection.equals("2")){
                System.out.println("Option 2"); // currentUser.getAccount().withdraw(double amount)
            }
            else if(acctOptionSelection.equals("3")){
                System.out.println("Option 3"); // currentUser.deposit(double amount)
            }
            else if(acctOptionSelection.equals("4")){
                System.out.println("Option 4"); // currentUser.transferInternal(double amount, AccountType acct, A)
            }
            else if(acctOptionSelection.equals("5")){
                System.out.println("Option 5"); // currentUser.transferExternal(double amount, User otherUser, AccountType acct)
            }
            else if(acctOptionSelection.equals("6")){
                System.out.println("Option 6"); // currentUser.createNewAccount(AccountType acct)
            }
            else if(acctOptionSelection.equals("7")){
                System.out.println("Option 7"); // currentUser.closeAccount(AccountType acct)
            }
            else if(acctOptionSelection.equals("8")){
                System.out.println("Option 8"); // currentUser.printTransactionHistory()
            }
            else if(acctOptionSelection.equals("00")){
                selectAccountScreen(userName);
            }
            else if(acctOptionSelection.equals("99")){
                System.exit(0);
            }
            else{
                Console.displayInvalidAccountOptionsScreen(userName,accountType);
            }
        }
    }
}