public class ATM {

    //User currentUser = new User();
    String tempPassword = "password123";


    public ATM(){

    }

    public void run(){
        Console console1 = new Console();

        console1.displayUserNamePrompt();
        String userName = Console.getStringInput();

        while(true){
            if(userName.equals("99")){
                break;
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
            if(password.equals(tempPassword)){ //make this password == currentUser.getPassword
                selectAccountScreen(userName);
            }
            else if(password.equals("00")){
                run();
            }
            else if(password.equals("99")){
                break;
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
                System.out.println("Option 1");
            }
            else if(acctOptionSelection.equals("2")){
                System.out.println("Option 2");
            }
            else if(acctOptionSelection.equals("3")){
                System.out.println("Option 3");
            }
            else if(acctOptionSelection.equals("4")){
                System.out.println("Option 4");
            }
            else if(acctOptionSelection.equals("5")){
                System.out.println("Option 5");
            }
            else if(acctOptionSelection.equals("6")){
                System.out.println("Option 6");
            }
            else if(acctOptionSelection.equals("7")){
                System.out.println("Option 7");
            }
            else if(acctOptionSelection.equals("00")){
                selectAccountScreen(userName);
            }
            else{
                Console.displayInvalidAccountOptionsScreen(userName,accountType);
            }
        }
    }
}
