public class ATM {

    public void run(){

        Console.displayUserNamePrompt();
        ArchiveOfUsers archive = new ArchiveOfUsers();
        User currentUser;


        while(true){
            String userName = Console.getStringInput();
            if(archive.checkForExistingUser(userName)){
                currentUser = archive.getArchivedUser(archive.getUserIndex(userName));
                passwordPromptScreen(currentUser);
            }
            else if(userName.equals("99")){
                System.exit(0);
            }
            else{
                Console.displayInvalidUserNamePrompt();
            }
        }
    }

    public void passwordPromptScreen(User currentUser){
        Console.displayPasswordPrompt(currentUser.getUserName());

        while(true){
            String password = Console.getStringInput();
            if(password.equals(currentUser.getPassword())){
                selectAccountScreen(currentUser);
            }
            else if(password.equals("00")){
                run();
            }
            else if(password.equals("99")){
                System.exit(0);
            }
            else{
                Console.displayInvalidPasswordPrompt(currentUser.getUserName());
            }

        }
    }

    public void selectAccountScreen(User currentUser){
        Console.displaySelectAccountScreen(currentUser.getUserName());

        while(true){
            String accountSelection = Console.getStringInput();

            if(accountSelection.equals("1")){
                accountOptionsScreen(currentUser,"Savings");
            }
            else if(accountSelection.equals("2")){
                accountOptionsScreen(currentUser,"Checking");
            }
            else if(accountSelection.equals("3")){
                accountOptionsScreen(currentUser,"Investment");
            }
            else if(accountSelection.equals("00")){
                run();
            }
            else if(accountSelection.equals("99")){
                System.exit(0);
            }
            else{
                Console.displayInvalidSelectAccountScreen(currentUser.getUserName());
            }
        }
    }

    public void accountOptionsScreen(User currentUser,String accountType) {
        Console.displayAccountOptionsScreen(currentUser.getUserName(),accountType);

        while(true){
            String acctOptionSelection = Console.getStringInput();
            if(acctOptionSelection.equals("1")){
                checkAccountBalanceScreen(currentUser,accountType);
            }
            else if(acctOptionSelection.equals("2")){
                withdrawPromptScreen(currentUser,accountType);
            }
            else if(acctOptionSelection.equals("3")){
                depositPromptScreen(currentUser,accountType);
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
                selectAccountScreen(currentUser);
            }
            else if(acctOptionSelection.equals("99")){
                System.exit(0);
            }
            else{
                Console.displayInvalidAccountOptionsScreen(currentUser.getUserName(),accountType);
            }
        }
    }

    public void checkAccountBalanceScreen(User currentUser,String accountType) {
        while(true) {
            double acctBalance;
            if (accountType.equals("Savings")) {
                acctBalance = currentUser.savingsAcct.checkBalance();
            }
            else if (accountType.equals("Checking")) {
                acctBalance = currentUser.checkingAcct.checkBalance();
            }
            else {
                acctBalance = currentUser.investmentAcct.checkBalance();
            }
            Console.displayCheckAcctBalance(currentUser.getUserName(), accountType, acctBalance);

            String acctOptionSelection = Console.getStringInput();
            if (acctOptionSelection.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (acctOptionSelection.equals("99")) {
                System.exit(0);
            }

        }
    }

    public void depositPromptScreen(User currentUser,String accountType) {
        Console.displayDepositPromptScreen(currentUser.getUserName(),accountType);

        while(true) {
            String depositAmount = Console.getStringInput();
            double acctBalance;
            if (accountType.equals("Savings")) {
                acctBalance = currentUser.savingsAcct.depositMoney(Double.parseDouble(depositAmount));
                depositDisplayScreen(currentUser,accountType,depositAmount,acctBalance);
            }
            else if (accountType.equals("Checking")) {
                acctBalance = currentUser.checkingAcct.depositMoney(Double.parseDouble(depositAmount));
                depositDisplayScreen(currentUser,accountType,depositAmount,acctBalance);
            }
            else if (accountType.equals("Investment")){
                acctBalance = currentUser.investmentAcct.depositMoney(Double.parseDouble(depositAmount));
                depositDisplayScreen(currentUser,accountType,depositAmount,acctBalance);
            }
            else if (depositAmount.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (depositAmount.equals("99")) {
                System.exit(0);
            }

        }
    }

    public void depositDisplayScreen(User currentUser,String accountType, String depositAmount, double acctBalance) {
        Console.displayDepositBalanceScreen(currentUser.getUserName(),accountType,depositAmount,acctBalance);

        while(true) {
            String command = Console.getStringInput();
            if (command.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (command.equals("99")) {
                System.exit(0);
            }

        }
    }


    public void withdrawPromptScreen(User currentUser,String accountType) {
        Console.displayWithdrawPromptScreen(currentUser.getUserName(),accountType);

        while(true) {
            String withdrawAmount = Console.getStringInput();
            double acctBalance;
            if (accountType.equals("Savings")) {
                if(currentUser.savingsAcct.withdraw(Double.parseDouble(withdrawAmount))){
                    acctBalance = currentUser.savingsAcct.checkBalance();
                    withdrawDisplayScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
                else{
                    acctBalance = currentUser.savingsAcct.checkBalance();
                    withdrawInsufficientFundsScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
            }
            else if (accountType.equals("Checking")) {
                if(currentUser.checkingAcct.withdraw(Double.parseDouble(withdrawAmount))){
                    acctBalance = currentUser.checkingAcct.checkBalance();
                    withdrawDisplayScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
                else{
                    acctBalance = currentUser.checkingAcct.checkBalance();
                    withdrawInsufficientFundsScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
            }
            else if (accountType.equals("Investment")){
                if(currentUser.investmentAcct.withdraw(Double.parseDouble(withdrawAmount))){
                    acctBalance = currentUser.checkingAcct.checkBalance();
                    withdrawDisplayScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
                else{
                    acctBalance = currentUser.investmentAcct.checkBalance();
                    withdrawInsufficientFundsScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
            }
            else if (withdrawAmount.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (withdrawAmount.equals("99")) {
                System.exit(0);
            }

        }
    }

    public void withdrawDisplayScreen(User currentUser,String accountType, String withdrawAmount, double acctBalance) {
        Console.displayWithdrawScreen(currentUser.getUserName(),accountType,withdrawAmount,acctBalance);

        while(true) {
            String command = Console.getStringInput();
            if (command.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (command.equals("99")) {
                System.exit(0);
            }

        }
    }


    public void withdrawInsufficientFundsScreen(User currentUser,String accountType, String withdrawAmount, double acctBalance) {
        Console.displayWithdrawInsufficientFundsScreen(currentUser.getUserName(),accountType,withdrawAmount,acctBalance);

        while(true) {
            String command = Console.getStringInput();
            if (command.equals("00")) {
                withdrawPromptScreen(currentUser,accountType);
            }
            else if (command.equals("99")) {
                System.exit(0);
            }

        }
    }
}