public class ATM {

    ArchiveOfUsers archive = new ArchiveOfUsers();

    public void run(){

        Console.displayUserNamePrompt();
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
                accountOptionsScreen(currentUser,currentUser.getSavingsAcct());
            }
            else if(accountSelection.equals("2")){
                accountOptionsScreen(currentUser, currentUser.getCheckingAcct());
            }
            else if(accountSelection.equals("3")){
                accountOptionsScreen(currentUser,currentUser.getInvestmentAcct());
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
                transferInternalAmountPromptScreen(currentUser,accountType);
            }
            else if(acctOptionSelection.equals("5")){
                transferExternalAmountPromptScreen(currentUser,accountType);
            }
            else if(acctOptionSelection.equals("6")){
                System.out.println("Option 6"); // currentUser.createNewAccount(AccountType acct)
            }
            else if(acctOptionSelection.equals("7")){
                System.out.println("Option 7"); // currentUser.closeAccount(AccountType acct)
            }
            else if(acctOptionSelection.equals("8")){
                printTransactionList(currentUser, accountType);
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
            else if(isDouble(depositAmount)&&Double.parseDouble(depositAmount)>0){
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
            Console.displayInvalidNumberEnteredScreen(currentUser.getUserName(),accountType.toString());
            String command = Console.getStringInput();
            if (command.equals("00")) {
                if(depWithTrans.equals("deposit")){
                    depositPromptScreen(currentUser,accountType);
                }
                else if(depWithTrans.equals("withdraw")){
                    withdrawPromptScreen(currentUser,accountType);
                }
                else if(depWithTrans.equals("transfer internal")){
                    transferInternalAmountPromptScreen(currentUser,accountType);
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
            else if(isDouble(withdrawAmount) && Double.parseDouble(withdrawAmount)>0){
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

    public void transferInternalAmountPromptScreen(User currentUser,BankAccounts accountType) {
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
            else if(isDouble(transferAmount) && Double.parseDouble(transferAmount)>0){
                if(accountType.checkBalance()>=Double.parseDouble(transferAmount)){
                    transferInternalAccountScreen(currentUser,accountType,Double.parseDouble(transferAmount));
                }
                else{
                    acctBalance = accountType.checkBalance();
                    transferInsufficientFundsScreen(currentUser,accountType,transferAmount,acctBalance);
                }
            }
            else{
                invalidNumberEnteredScreen(currentUser,accountType,"transfer internal");
            }
        }
    }

    public void transferInternalAccountScreen(User currentUser,BankAccounts accountType, double transferAmount) {

        while(true) {
            Console.displayUserAccountToTransferToPromptScreen(currentUser.getUserName(),accountType.toString(),"account");
            String accountToTransferTo = Console.getStringInput();


            if (accountToTransferTo.equals("00")) {
                transferInternalAmountPromptScreen(currentUser, accountType);
            }
            else if (accountToTransferTo.equals("99")) {
                System.exit(0);
            }
            else if (accountToTransferTo.equalsIgnoreCase("savings") && !accountType.equals(currentUser.getSavingsAcct())) {
                accountType.withdraw(transferAmount);
                currentUser.getSavingsAcct().depositMoney(transferAmount);
                internalTransferDisplayScreen(currentUser,accountType,transferAmount,currentUser.getSavingsAcct());
            }
            else if (accountToTransferTo.equalsIgnoreCase("checking") && !accountType.equals(currentUser.getCheckingAcct())) {
                accountType.withdraw(transferAmount);
                currentUser.getCheckingAcct().depositMoney(transferAmount);
                internalTransferDisplayScreen(currentUser,accountType,transferAmount,currentUser.getCheckingAcct());
            }
            else if (accountToTransferTo.equalsIgnoreCase("investment") && !accountType.equals(currentUser.getInvestmentAcct())) {
                accountType.withdraw(transferAmount);
                currentUser.getInvestmentAcct().depositMoney(transferAmount);
                internalTransferDisplayScreen(currentUser,accountType,transferAmount,currentUser.getInvestmentAcct());
            }
            else {
                invalidNumberEnteredScreen(currentUser, accountType, "transfer internal");
            }
        }
    }

    public void internalTransferDisplayScreen(User currentUser,BankAccounts accountType, double transferAmount, BankAccounts accountToTransferTo) {
        String transferToBalance = "";
        transferToBalance += accountToTransferTo.checkBalance();
        String transferFromBalance = "";
        transferFromBalance += accountType.checkBalance();

        while(true) {
            Console.diplayTransferBalanceScreen(currentUser.getUserName(),accountType.toString(),transferAmount,"Transferred",accountType.toString(),transferFromBalance,accountToTransferTo.toString(),transferToBalance);
            String command = Console.getStringInput();
            if (command.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (command.equals("99")) {
                System.exit(0);
            }
        }
    }

    public void transferExternalAmountPromptScreen(User currentUser,BankAccounts accountType) {
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
            else if(isDouble(transferAmount) && Double.parseDouble(transferAmount)>0){
                if(accountType.checkBalance() >= Double.parseDouble(transferAmount)){
                    transferExternalUserPrompt(currentUser,accountType,Double.parseDouble(transferAmount));
                }
                else{
                    acctBalance = accountType.checkBalance();
                    transferInsufficientFundsScreen(currentUser,accountType,transferAmount,acctBalance);
                }
            }
            else{
                invalidNumberEnteredScreen(currentUser,accountType,"transfer internal");
            }
        }
    }

    public void transferExternalUserPrompt(User currentUser,BankAccounts accountType, double transferAmount) {
        while(true) {
            Console.displayUserAccountToTransferToPromptScreen(currentUser.getUserName(),accountType.toString(),"user");
            String userName = Console.getStringInput();
            User userToTransferTo;

            if (userName.equals("00")) {
                accountOptionsScreen(currentUser, accountType);
            } else if (userName.equals("99")) {
                System.exit(0);
            } else if (archive.checkForExistingUser(userName)) {
                userToTransferTo = archive.getArchivedUser(archive.getUserIndex(userName));
                transferExternalAccountScreen(currentUser,accountType,transferAmount,userToTransferTo);
            } else {
                transferExternalUnknownUser(currentUser,accountType,transferAmount);
            }
        }
    }

    public void transferExternalUnknownUser(User currentUser,BankAccounts accountType, double transferAmount) {
        Console.displayTransferExternalUnknownUserScreen(currentUser.getUserName(),accountType.toString());

        while(true) {
            String command = Console.getStringInput();
            if (command.equals("00")) {
                transferExternalUserPrompt(currentUser,accountType,transferAmount);
            }
            else if (command.equals("99")) {
                System.exit(0);
            }
        }
    }

    public void transferExternalAccountScreen(User currentUser,BankAccounts accountType, double transferAmount,User userToTransferTo) {
        while(true) {
            Console.displayUserAccountToTransferToPromptScreen(currentUser.getUserName(),accountType.toString(),"account");
            String accountToTransferTo = Console.getStringInput();

            if (accountToTransferTo.equals("00")) {
                transferInternalAmountPromptScreen(currentUser, accountType);
            }
            else if (accountToTransferTo.equals("99")) {
                System.exit(0);
            }
            else if (accountToTransferTo.equalsIgnoreCase("savings")) {
                accountType.withdraw(transferAmount);
                userToTransferTo.getSavingsAcct().depositMoney(transferAmount);
                externalTransferDisplayScreen(currentUser,accountType,transferAmount,userToTransferTo,userToTransferTo.getSavingsAcct());
            }
            else if (accountToTransferTo.equalsIgnoreCase("checking")) {
                accountType.withdraw(transferAmount);
                userToTransferTo.getCheckingAcct().depositMoney(transferAmount);
                externalTransferDisplayScreen(currentUser,accountType,transferAmount,userToTransferTo,userToTransferTo.getCheckingAcct());
            }
            else if (accountToTransferTo.equalsIgnoreCase("investment")) {
                accountType.withdraw(transferAmount);
                userToTransferTo.getInvestmentAcct().depositMoney(transferAmount);
                externalTransferDisplayScreen(currentUser,accountType,transferAmount,userToTransferTo,userToTransferTo.getInvestmentAcct());
            }
            else {
                invalidNumberEnteredScreen(currentUser, accountType, "transfer external");
            }
        }
    }

    public void externalTransferDisplayScreen(User currentUser,BankAccounts accountType, double transferAmount, User userToTransferTo, BankAccounts accountToTransferTo) {
        String transferToBalance = "";
        transferToBalance += accountToTransferTo.checkBalance();
        String transferFromBalance = "";
        transferFromBalance += accountType.checkBalance();

        while(true) {
            Console.diplayExternalTransferBalanceScreen(currentUser.getUserName(),accountType.toString(),transferAmount,"Transferred",accountType.toString(),transferFromBalance,accountToTransferTo.toString(),transferToBalance,userToTransferTo.getUserName());
            String command = Console.getStringInput();
            if (command.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (command.equals("99")) {
                System.exit(0);
            }
        }
    }

    public void transferInsufficientFundsScreen(User currentUser,BankAccounts accountType, String transferAmount, double acctBalance) {
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


    public void printTransactionList(User currentUser, BankAccounts accountType) {

        while(true) {
            Console.displayTransactionListScreen(currentUser.getUserName(), accountType.getTransactionHistory());
            String command = Console.getStringInput();
            if (command.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (command.equals("99")) {
                System.exit(0);
            }
        }
    }


    public void deleteAccount(User currentUser, BankAccounts accountType) {
        while(true) {
            Console.displayAreYouSureScreen(currentUser.getUserName());
            String command = Console.getStringInput();
            if (command.equals("00")) {
                accountOptionsScreen(currentUser,accountType);
            }
            else if (command.equals("99")) {
                System.exit(0);
            } else if (command.equals(currentUser.getPassword())) {
                archive.deleteAccount(currentUser);
                accountDeletedScr(currentUser.toString());
            }
        }
    }

    private void accountDeletedScr(User currentUser) {
        while(true) {
            Console.accountDeletedScreen(currentUser.getUserName(), currentUser.getCheckingAcct().checkBalance(), currentUser.getSavingsAcct().checkBalance(), currentUser.getInvestmentAcct().checkBalance());
            String command = Console.getStringInput();
            if (command.equals("00")) {
                run();
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