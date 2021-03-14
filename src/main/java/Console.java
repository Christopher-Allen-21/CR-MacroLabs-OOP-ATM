import java.util.Scanner;

public class Console {

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void displayUserNamePrompt(){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("| Please enter your user name: |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayInvalidUserNamePrompt(){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("|    Username not recognized   |");
        Console.println("| Please enter valid user name:|");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayPasswordPrompt(String userName){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                    ",userName);
        Console.println("|                              |");
        Console.println("| Please enter your password:  |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|   Enter 00 to Switch Users   |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayInvalidPasswordPrompt(String userName){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                    ",userName);
        Console.println("|                              |");
        Console.println("| Invalid Password.            |");
        Console.println("| Please enter your password:  |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("|   Enter 00 to Switch Users   |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displaySelectAccountScreen(String userName){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                    ",userName);
        Console.println("|                              |");
        Console.println("| Please enter a number:       |");
        Console.println("|    1. Savings Account        |");
        Console.println("|    2. Checking Account       |");
        Console.println("|    3. Investment Account     |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 to Return to Login  |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayInvalidSelectAccountScreen(String userName){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                    ",userName);
        Console.println("|                              |");
        Console.println("| Invalid Selection.           |");
        Console.println("| Please enter a number:       |");
        Console.println("|    1. Savings Account        |");
        Console.println("|    2. Checking Account       |");
        Console.println("|    3. Investment Account     |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 to Return to Login  |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayAccountOptionsScreen(String userName,String accountType){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("| Please enter a number:       |");
        Console.println("|    1. Check Balance          |");
        Console.println("|    2. Withdraw               |");
        Console.println("|    3. Deposit                |");
        Console.println("|    4. Transfer (Internal)    |");
        Console.println("|    5. Transfer (External)    |");
        Console.println("|    6. Open New Account       |");
        Console.println("|    7. Close Account          |");
        Console.println("|    8. Print Trans. History   |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Previous Screen |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayInvalidAccountOptionsScreen(String userName,String accountType){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("| Invalid Selection.           |");
        Console.println("| Please enter a number:       |");
        Console.println("|    1. Check Balance          |");
        Console.println("|    2. Withdraw               |");
        Console.println("|    3. Deposit                |");
        Console.println("|    4. Transfer (Internal)    |");
        Console.println("|    5. Transfer (External)    |");
        Console.println("|    6. Open New Account       |");
        Console.println("|    7. Close Account          |");
        Console.println("|    8. Print Trans. History   |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Previous Screen |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayCheckAcctBalance(String userName,String accountType,double accountBalance){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("  Account Balance: $%s          ",accountBalance);
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Previous Screen |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayDepositWithdrawTransPromptScreen(String userName,String accountType,String command,double acctBalance){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("  Account Balance: $%s          ",acctBalance);
        Console.println("  Enter amount to %s:           ",command);
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Previous Screen |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayDepositWithdrawBalanceScreen(String userName,String accountType,String amountChanged,String command,double acctBalance){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("  Amount %s: $%s         ",command,amountChanged);
        Console.println("  Account Balance: $%s          ",acctBalance);
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Another Trans.  |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void diplayTransferBalanceScreen(String userName,String accountType,double transferAmount,String command,String transferFrom, String transferFromBalance, String transferTo,String transferToBalance){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("  Amount %s: $%s         ",command,transferAmount);
        Console.println("  %s Acct Balance: $%s          ",transferFrom,transferFromBalance);
        Console.println("  %s Acct Balance: $%s          ",transferTo,transferToBalance);
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Another Trans.  |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayInvalidNumberEnteredScreen(String userName,String accountType){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("|        Invalid Entry.        |");
        Console.println("|    Enter 00 to return to     |");
        Console.println("|        previous screen       |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Previous Screen |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayWithdrawTransInsufficientFundsScreen(String userName,String accountType,String command, double acctBalance){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println("  Insufficient Funds to %s      ",command);
        Console.println("  Account Balance: $%s          ",acctBalance);
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Previous Screen |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

    public static void displayUserAccountToTransferToPromptScreen(String userName,String accountType,String accountOrUser){
        Console.println("--------------------------------");
        Console.println("|    ZipCodeWilmington ATM     |");
        Console.println("--------------------------------");
        Console.println("|                              |");
        Console.println("  User: %s                      ",userName);
        Console.println("  Account Type: %s              ",accountType);
        Console.println("|                              |");
        Console.println(" Enter %s to transfer to:       ",accountOrUser);
        Console.println("|                              |");
        Console.println("|                              |");
        Console.println("--------------------------------");
        Console.println("| Enter 00 for Previous Screen |");
        Console.println("|       Enter 99 to Quit       |");
        Console.println("--------------------------------");
    }

}