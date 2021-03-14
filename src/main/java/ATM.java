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
                accountOptionsScreen(currentUser,currentUser.savingsAcct);
            }
            else if(accountSelection.equals("2")){
                accountOptionsScreen(currentUser, currentUser.checkingAcct);
            }
            else if(accountSelection.equals("3")){
                accountOptionsScreen(currentUser,currentUser.investmentAcct);
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

    public void accountOptionsScreen(User currentUser,BankAccounts accountType) {
        Console.displayAccountOptionsScreen(currentUser.getUserName(),accountType.toString());

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
                Console.displayInvalidAccountOptionsScreen(currentUser.getUserName(),accountType.toString());
            }
        }
    }

    public void checkAccountBalanceScreen(User currentUser,BankAccounts accountType) {
        while(true) {
            double acctBalance;
            acctBalance = accountType.checkBalance();

            Console.displayCheckAcctBalance(currentUser.getUserName(), accountType.toString(), acctBalance);

            String acctOptionSelection = Console.getStringInput();
            if (acctOptionSelection.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (acctOptionSelection.equals("99")) {
                System.exit(0);
            }

        }
    }

    public void depositPromptScreen(User currentUser,BankAccounts accountType) {
        Console.displayDepositWithdrawTransPromptScreen(currentUser.getUserName(),accountType.toString(),"deposit",accountType.checkBalance());

        while(true) {
            String depositAmount = Console.getStringInput();
            double acctBalance;

            if (depositAmount.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (depositAmount.equals("99")) {
                System.exit(0);
            }
            else if(isDouble(depositAmount)){
                acctBalance = accountType.depositMoney(Double.parseDouble(depositAmount));
                depositDisplayScreen(currentUser,accountType,depositAmount,acctBalance);
            }
            else{
                invalidNumberEnteredScreen(currentUser,accountType,"deposit");
            }

        }
    }

    public void invalidNumberEnteredScreen(User currentUser,BankAccounts accountType,String depWithTrans) {

        while(true) {
            Console.displayInvalidNumberEnteredScreen(currentUser.getUserName(),accountType.toString(),depWithTrans);
            String command = Console.getStringInput();
            if (command.equals("00")) {
                if(depWithTrans.equals("deposit")){
                    depositPromptScreen(currentUser,accountType);
                }
                else if(depWithTrans.equals("withdraw")){
                    withdrawPromptScreen(currentUser,accountType);
                }
                else if(depWithTrans.equals("transfer internal")){
                    transferPromptScreen(currentUser,accountType);
                }
            }
            else if (command.equals("99")) {
                System.exit(0);
            }

        }
    }

    public void depositDisplayScreen(User currentUser,BankAccounts accountType, String depositAmount, double acctBalance) {
        Console.displayDepositWithdrawBalanceScreen(currentUser.getUserName(),accountType.toString(),depositAmount,"Deposited",acctBalance);

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


    public void withdrawPromptScreen(User currentUser,BankAccounts accountType) {
        Console.displayDepositWithdrawTransPromptScreen(currentUser.getUserName(),accountType.toString(),"withdraw", accountType.checkBalance());

        while(true) {
            String withdrawAmount = Console.getStringInput();
            double acctBalance;

            if (withdrawAmount.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (withdrawAmount.equals("99")) {
                System.exit(0);
            }
            else if(isDouble(withdrawAmount)){
                if(accountType.withdraw(Double.parseDouble(withdrawAmount))){
                    acctBalance = accountType.checkBalance();
                    withdrawDisplayScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
                else{
                    acctBalance = accountType.checkBalance();
                    withdrawInsufficientFundsScreen(currentUser,accountType,withdrawAmount,acctBalance);
                }
            }
            else{
                invalidNumberEnteredScreen(currentUser,accountType,"withdraw");
            }

        }
    }

    public void withdrawDisplayScreen(User currentUser,BankAccounts accountType, String withdrawAmount, double acctBalance) {
        Console.displayDepositWithdrawBalanceScreen(currentUser.getUserName(),accountType.toString(),withdrawAmount,"Withdrawn",acctBalance);

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


    public void withdrawInsufficientFundsScreen(User currentUser,BankAccounts accountType, String withdrawAmount, double acctBalance) {
        Console.displayWithdrawTransInsufficientFundsScreen(currentUser.getUserName(),accountType.toString(),"Withdraw",acctBalance);

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

    public void transferPromptScreen(User currentUser,BankAccounts accountType) {
        Console.displayDepositWithdrawTransPromptScreen(currentUser.getUserName(),accountType.toString(),"transfer",accountType.checkBalance());

        while(true) {
            String transferAmount = Console.getStringInput();
            double acctBalance;

            if (transferAmount.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (transferAmount.equals("99")) {
                System.exit(0);
            }
            else if(accountType.checkBalance()>=Double.parseDouble(transferAmount)){
                //PROMPT FOR ACCOUNT TO TRANSFER TO
                transferToChosenAccountScreen(currentUser,accountType,transferAmount);
            }
            else{
                acctBalance = accountType.checkBalance();
                transferInsufficientFundsScreen(currentUser,accountType,transferAmount,acctBalance);
            }


        }
    }

    public void transferToChosenAccountScreen(User currentUser,BankAccounts accountType, String transferAmount) {
        Console.displayAccountToTransferToPromptScreen(currentUser.getUserName(),accountType.toString());


    }

    public void transferInsufficientFundsScreen(User currentUser,BankAccounts accountType, String withdrawAmount, double acctBalance) {
        Console.displayWithdrawTransInsufficientFundsScreen(currentUser.getUserName(),accountType.toString(),"Transfer",acctBalance);

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






    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}